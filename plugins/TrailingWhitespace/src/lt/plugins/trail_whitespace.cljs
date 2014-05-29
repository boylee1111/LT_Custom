(ns lt.plugins.trail-whitespace
  (:require
   [lt.object       :as object]
   [lt.objs.editor  :as editor]
   [lt.objs.command :as cmd])
  (:require-macros
   [lt.macros :refer [behavior]]))

(def overlay
  (clj->js
   {:token (fn [stream]
             (when-let [_ (.next stream)]
               (let [s           (.-string stream)
                     length      (.-length s)
                     space-count (count (take-while #(.match % #"\s") (reverse s)))
                     space-start (- length space-count)]

                 (if (> space-start (.-pos stream))
                   (do
                     (set! (.-pos stream) space-start)
                     nil)
                   (do
                     (set! (.-pos stream) length)
                     "trailingspace" )))))}))


(behavior ::show-trailing-whitespace
                  :triggers #{:object.instant}
                  :reaction (fn [this]
                              (.addOverlay (editor/->cm-ed this) overlay)))

(behavior ::hide-trailing-whitespace
                  :triggers #{:object.instant}
                  :reaction (fn [this]
                              (.removeOverlay (editor/->cm-ed this) overlay)))

(cmd/command
 {:command :toggle-trail-whitespace
  :desc    "Editor: Toggle trail whitespace"
  :exec    (fn []
             (if (object/in-tag? :editor ::show-trailing-whitespace)
               (do
                 (object/remove-tag-behaviors :editor [::show-trailing-whitespace])
                 (object/tag-behaviors :editor [::hide-trailing-whitespace]))
               (do
                 (object/remove-tag-behaviors :editor [::hide-trailing-whitespace])
                 (object/tag-behaviors :editor [::show-trailing-whitespace]))))})
