(ns lt.plugins.gitlight.common-ui
  (:require [lt.object :as object]
            [lt.objs.tabs :as tabs]
            [lt.objs.popup :as popup]
            [lt.objs.context :as ctx]
            [lt.util.dom :as dom])
  (:require-macros [lt.macros :refer [defui behavior]]))



(defui button [n f fun]
  [:button [:nobr n]]
  :click (fn [] (fun n f)))


(defui classy-button [cls n f fun]
  [:button {:class cls} [:nobr n]]
  :click (fn [] (fun n f)))


(defui text-input []
  [:input {:type "text" :placeholder "message"}]
  :focus (fn []
           (ctx/in! :popup.input))
  :blur (fn []
          (ctx/out! :popup.input)))


(defn input-popup [mesg label fun]
  (let [input (text-input)
        p (popup/popup! {:header mesg
                         :body input
                         :buttons [{:label label
                                    :action (fn []
                                              (fun (dom/val input)))}
                                   {:label "cancel"}]})]))


(defn dom-truncate [node]
  (set! (.-innerHTML node) ""))



(defn dom-reset [node new-cnt]
  (dom-truncate node)
  (dom/append node new-cnt))



(defn make-refresh-behavior [k ui-fun]
  (behavior k
            :triggers #{:refresh}
            :reaction (fn [this]
                        (let [new-cnt (ui-fun this)]
                        (dom-reset (dom/parent (:content @this)) new-cnt)
                        (object/merge! this {:content new-cnt} )))))



(behavior ::refresh-tab
          :triggers #{:out}
          :reaction (fn [this command stdout stderr]
                      (tabs/add-or-focus! this)
                      (object/merge! this {:result stdout})
                      (object/raise this :refresh)))



(defn make-keywords [k]
   (let [kwrdstr (subs (str k) 1)]
     (map (fn [x] (keyword (str kwrdstr x)))
          ["-out" "-refresh-results" "-refresh-tab-results" "-output"])))


(behavior ::merge-mult-results
          :triggers [:mult-outs]
          :reaction (fn [this results]
                      (tabs/add-or-focus! this)
                      (object/merge! this {:results (map #(nth % 2) results)})
                      (object/raise this :refresh)))

(defui not-a-thing []
  [:div "nothing"])

(defn make-output-tab-object [window-name k ui-fun]
  (let [[tab-kwd
         refresh-kwd
         refresh-tab-kwd
         command-output-kwd] (make-keywords k)

        refresh-results (make-refresh-behavior refresh-kwd ui-fun)

        tab-obj (object/object* tab-kwd
                                :tags [:gitlight-tab.out
                                       :gitlight-log-history]
                                :name window-name
                                :result nil
                                :results nil
                                :behaviors [::on-close-destroy
                                            ::refresh-tab
                                            ::merge-mult-results
                                            refresh-results]
                                :init (fn [this]
                                        (not-a-thing))
                                        )

;;                                 :init (fn [this]
;;                                         (ui-fun this)))]
       ]

    (object/create tab-obj)))




(defn make-button [n f fun]
  (button n f (if (= fun nil)
                not-implemented-popup
                fun)))

(defn make-classy-button [n f fun]
  (classy-button (str n) n f (if (= fun nil)
                               not-implemented-popup
                               fun)))


(defn not-implemented-popup [ n f ]
  (popup/popup!
   {:header "Not yet implemented..."
    :body (str "perform action " n " on " f)
    :buttons [{:label "ok"}]}))



(behavior ::on-close-destroy
          :triggers #{:close}
          :reaction (fn [this]
                      (when-let [ts (:lt.objs.tabs/tabset @this)]
                        (when (= (count (:objs @ts)) 1)
                          (tabs/rem-tabset ts)))
                      (object/raise this :destroy)))
