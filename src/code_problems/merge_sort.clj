(ns code-problems.merge-sort)

(defn merge-vec
  [vec-a vec-b]
  (loop [va vec-a
         vb vec-b
         result []]
    (cond
      (empty? va) (into result vb)
      (empty? vb) (into result va)
      :else (let [[a & rest-a] va [b & rest-b] vb]
              (if (> a b)
                (recur va rest-b (conj result b))
                (recur rest-a vb (conj result a)))))))

(defn merge-sort
  ([v]
    (if (< (count v) 2)
      v
      (let [half (quot (count v) 2)]
           (merge-sort (vec (take half v)) (vec (drop half v))))))
  ([va vb]
    (merge-vec (merge-sort va) (merge-sort vb))))
