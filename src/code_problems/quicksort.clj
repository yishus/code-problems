(ns code-problems.quicksort)

(defn quicksort
  [[pivot & rest]]
  (when pivot
    (concat
     (quicksort (filter #(< % pivot) rest))
     [pivot]
     (quicksort (filter #(>= % pivot) rest)))))
