(defpackage :gigasecond-anniversary
  (:use :cl)
  (:export :from))
(in-package :gigasecond-anniversary)

(defun from (year month day hour minute second)
  (let ((ts (encode-universal-time second minute hour day month year)))
       (to-alien-time (+ 1000000000 ts))))

(defun to-alien-time (seconds)
  (multiple-value-bind (second minute hour day month year) (decode-universal-time seconds)
    (list year month day hour minute second)))
