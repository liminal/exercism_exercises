(defpackage :perfect-numbers
  (:use :cl)
  (:export :classify))

(in-package :perfect-numbers)

(defun classify (number)
  (let ((asum (aliquot-sum number)))
       (cond 
         ((< number 1) nil)
         ((> asum number) "abundant")
         ((< asum number) "deficient")
         ((= asum number) "perfect"))))

(defun aliquot-sum (number)
  "calculate sum of factors of number not including itself"
  (loop for x from 1 
        to (/ number 2) ; reasonable shortcut
        if (= 0 (mod number x)) 
        sum x into total
        finally (return total)))