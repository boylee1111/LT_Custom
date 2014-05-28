(ns lt.plugins.gitlight.remote-com
  (:require [lt.plugins.gitlight.git :as git]))



(defn git-fetch []
  (git/git-command-ignore-out "fetch"))



(defn git-push []
  (git/git-command-ignore-out "push"))


(defn git-push-remote-branch [remote branch]
  (git/git-command-ignore-out "push" remote branch))


(defn git-pull []
  (git/git-command-ignore-out "pull"))
