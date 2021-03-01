(ns cljtemplate.integration.core-test
  (:require [clojure.spec.test.alpha :as stest]
            [clojure.test :refer [deftest is]]

            [kaocha.repl :refer [run]]

            [cljtemplate.core :as core]))

(comment (run 'cljtemplate.integration.core-test/dummy))
(deftest dummy
  (is (= 1 1)))
