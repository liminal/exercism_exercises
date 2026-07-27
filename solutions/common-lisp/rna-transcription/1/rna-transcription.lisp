(defpackage :rna-transcription
  (:use :cl)
  (:export :to-rna))
(in-package :rna-transcription)

(defun to-rna (str)
  "Transcribe a string representing DNA nucleotides to RNA."
  (map 'string #'nucleotide-complement str))

(defun nucleotide-complement (c) 
  (cond 
    ((char= c #\G) #\C)
    ((char= c #\C) #\G)
    ((char= c #\T) #\A)
    ((char= c #\A) #\U)))