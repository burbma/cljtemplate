(ns cljtemplate.unit.utils-test
  (:require [clojure.spec.test.alpha :as stest]
            [clojure.test :refer [deftest is]]

            [kaocha.repl :refer [run]]

            [cljtemplate.utils :as u]))

(comment (run 'cljtemplate.unit.utils-test/expand-home))
(deftest expand-home
  (let [f u/expand-home
        home (System/getProperty "user.home")
        e1 [home] a1 (f ["~"])
        e2 [(str home "/nacho/cat")] a2 (f ["~/nacho/cat"])
        e3 [(str home "/") "nacho" "cat"] a3 (f ["~/" "nacho" "cat"])]
    (is (= e1 a1))
    (is (= e2 a2))
    (is (= e3 a3))))
