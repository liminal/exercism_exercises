(defpackage :difference-of-squares
  (:use :cl)
  (:export :sum-of-squares
           :square-of-sum
           :difference))

(in-package :difference-of-squares)

(defun square-of-sum (n)
  "Calculates the square of the sum for a given number."
  (expt (apply #'+ (range n)) 2))

(defun sum-of-squares (n)
  "Calculates the sum of squares for a given number."
  (apply #'+ (map 'list (lambda (x) (expt x 2)) (range n))))

(defun difference (n)
  "Finds the diff. between the square of the sum and the sum of the squares."
  (- (square-of-sum n) (sum-of-squares n)))

(defun range (n)
  (if (> n 0) 
      (cons n (range (- n 1)))
      '()))
