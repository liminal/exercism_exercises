(defpackage :leap
  (:use :cl)
  (:export :leap-year-p))

(in-package :leap)

(defun leap-year-p (year)
  (cond 
    ((= (mod year 400) 0) t)
    ((= (mod year 100) 0) nil)
    ((= (mod year 4) 0) t)
    (t nil)))
