(ns cljtemplate.spec
  (:require [clojure.spec.alpha :as s]))

;; I'd use this namespace to declare specs that are "domain specs", meaning
;; ones that will recur all over my application. Other times, as you see in
;; utils.clj I just make one off's as naming them might get too specific or
;; not generalize well.

(s/def ::thing string?)
