(defpackage :grains
  (:use :cl)
  (:export :square :total))
(in-package :grains)

(defun square (n) (expt 2 (1- n) ))

(defun total () 
  (loop for x 
        from 1 
        to 64 
        sum (square x) into total
        finally (return total)))
