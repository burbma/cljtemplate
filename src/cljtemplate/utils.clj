(ns cljtemplate.utils
  (:require [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [clojure.string :as str]))


(defn ^:private expand-home* [s]
  (if (.startsWith s "~")
    (str/replace-first s "~" (System/getProperty "user.home"))
    s))
(s/fdef expand-home*
  :args (s/cat :s string?)
  :ret (s/and string?
              #(not (str/starts-with? % "~"))))

(defn expand-home [path-parts]
  (if (empty? path-parts)
    []
    (cons (expand-home* (first path-parts))
          (rest path-parts))))
(s/fdef expand-home
  :args (s/cat :path-parts (s/coll-of string?))
  :ret (s/coll-of string?))

;; TODO: spec macros? I'm pretty sure you can but I haven't done it so I'd have
;; to review the specifics.
(defmacro sym->map
  "Allows you to create a map whose keys are the symbol names.

  (let [a 1 b 2 c 3]
    (sym->map a b c))
  ;; => {:a 1 :b 2 :c 3}
  "
  [& vars]
  (reduce (fn [r v]
            (assoc r (keyword v) v))
          {} vars))
