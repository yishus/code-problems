(ns code-problems.heap-sort)

(defn last-i
  [vector]
  (dec(count vector)))

(defn left-child-i
  [i]
  (inc (* 2 i)))

(defn right-child-i
  [i]
  (+ (* 2 i) 2))

(defn parent-i
  [i]
  (quot (dec i) 2))

(defn heapify-start-i
  [vector]
  (parent-i (last-i vector)))

(defn swap
  [vector a b]
  (let [va (get vector a)
        vb (get vector b)]
    (assoc (assoc vector a vb) b va)))

(defn sift-down
  [vector i]
  (if (> (left-child-i i) (last-i vector))
    vector
    (let [left-child (get vector (left-child-i i))
          value (get vector i)
          right-child (get vector (right-child-i i))]
      (if (= i 0)
        (cond
          (< value left-child) (swap vector i (left-child-i i))
          (and (some? right-child) (< value right-child)) (swap vector i (right-child-i i))
          :else vector)
        (cond
          (< value left-child) (sift-down (swap vector i (left-child-i i)) (parent-i i))
          (and (some? right-child) (< value right-child)) (sift-down (swap vector i (right-child-i i)) (parent-i i))
          :else vector)))))

(defn heapify
  [vector]
  (if (<= (count vector) 1)
    vector
    (loop [v vector
           i (heapify-start-i vector)]
      (if (< i 0)
        v
        (recur (sift-down v i) (dec i))))))

(defn heap-remove-first-and-heapify
  [vector]
  (if (<= (count vector) 1)
    [(first vector) []]
    [(first vector) (sift-down (subvec (swap vector 0 (last-i vector)) 0 (last-i vector)) 0)]))

(defn heap-sort
  [vector]
  (loop [result []
         v (heapify vector)
         i (count vector)]
    (if (= i 0)
      result
      (let [[val vec] (heap-remove-first-and-heapify v)]
        (recur (conj result val) vec (dec i))))))
