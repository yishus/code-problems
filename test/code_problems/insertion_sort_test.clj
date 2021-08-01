(ns code-problems.insertion-sort-test
  (:require [clojure.test :refer :all]
            [code-problems.insertion-sort :refer :all]))

(deftest insertion-sort-test
  (testing "Should sort vector."
    (is (= (insertion-sort [4 1 3]) [1 3 4]))))
