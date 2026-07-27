(defpackage :darts
  (:use :cl)
  (:export :score))

(in-package :darts)

(defun score (x y)
  (let ((distance2 (+ (* x x) (* y y))))
       (cond 
         ((<= distance2 1) 10)
         ((<= distance2 25) 5)
         ((<= distance2 100) 1)
         (t 0))))
