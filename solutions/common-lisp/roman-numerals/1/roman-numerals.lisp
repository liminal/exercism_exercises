(defpackage :roman-numerals
  (:use :cl)
  (:export :romanize))

(in-package :roman-numerals)

(defun romanize (number)
  "Returns the Roman numeral representation for a given number."
  (romanize-impl number ""))

(defun romanize-impl (number str)
  (cond 
    ((>= number 1000) (romanize-impl (- number 1000) (concatenate 'string  str "M")))
    ((>= number 900) (romanize-impl (- number 900) (concatenate 'string  str "CM")))
    ((>= number 500) (romanize-impl (- number 500) (concatenate 'string  str "D")))
    ((>= number 400) (romanize-impl (- number 400) (concatenate 'string  str "CD")))
    ((>= number 100) (romanize-impl (- number 100) (concatenate 'string  str "C")))
    
    ((>= number 90) (romanize-impl (- number 90) (concatenate 'string  str "XC")))
    ((>= number 50) (romanize-impl (- number 50) (concatenate 'string  str "L")))
    ((>= number 40) (romanize-impl (- number 40) (concatenate 'string  str "XL")))
    ((>= number 10) (romanize-impl (- number 10) (concatenate 'string  str "X")))
    
    ((>= number 9) (romanize-impl (- number 9) (concatenate 'string  str "IX")))
    ((>= number 5) (romanize-impl (- number 5) (concatenate 'string  str "V")))
    ((>= number 4) (romanize-impl (- number 4) (concatenate 'string  str "IV")))
    ((>= number 1) (romanize-impl (- number 1) (concatenate 'string  str "I")))
    (t str)))