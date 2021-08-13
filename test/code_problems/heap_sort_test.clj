(ns code-problems.heap-sort-test
  (:require [clojure.test :refer :all]
            [code-problems.heap-sort :refer :all]))

(deftest heap-sort-test
  (testing "swap should swap value at the 2 indices"
    (is (= (swap [4 1 3] 0 1) [1 4 3])))
  (testing "sift down should move a small parent down"
    (is (= (sift-down [1 2 3 4] 0) [2 4 3 1]))))
