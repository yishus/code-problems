(ns code-problems.binary-search)

(defn binary-search
  [vector target]
  (loop [start 0
        end (dec (count vector))]
  (if (= start end)
    (if (= (get vector start) target)
      start
      nil)
    (let [guess (+ (quot (- end start) 2) start)
          guess-value (get vector guess)]
      (cond
        (= guess-value target) guess
        (< guess-value target) (recur (inc guess) end)
        (> guess-value target) (recur start (dec guess)))))))
