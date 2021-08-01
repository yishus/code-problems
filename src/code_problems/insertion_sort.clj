(ns code-problems.insertion-sort)

(defn insert
  [vector element]
  (loop [idx 0]
    (cond
      (= idx (count vector)) (conj vector element)
      (< element (get vector idx)) (vec (concat (take idx vector) [element] (take-last (- (count vector) idx) vector)))
      :else (recur (inc idx)))))

(defn insertion-sort
  [vector]
  (loop [idx 0
         result []]
    (if (= idx (count vector))
      result
      (recur (inc idx) (insert result (get vector idx))))))
