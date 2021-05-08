# Abstract
To predict the final grade and explore the importance of attribute selection and classification algorithm on a dataset of student lifestyle information, we ran an analysis using the Weka datamining toolkit. The results shows that the dataset is insufficient to accurately predict the letter or number grade a student will receive, but sufficient to predict a binary pass-fail, using J48 (C4.5) or Logistic Regression and a minor subset of attributes including the student's number of past failures (failures), intent to pursue higher education (higher) and the presence of additional school support (schoolsup) as the most relevant features.



## Objective
Choose a practical dataset (as opposed to the example ones we used in class) with a reasonable size. Download the data, read the description, and try various approaches to solve the problem as best as you can.

The objective of the chosen dataset is to predict the final grade (G3) of a student


## The Student Performance Dataset
The Student Performance Data Set [1] consists of 1044 records recorded from the 2005-2006 school year of two secondary schools in Portugal. The records contain 33 attributes consisting of academic information for 662 unique students in two courses – math and portuguese language (port) – as well as self-reported survey data regarding the students home life and school-related efforts (see Table 1 for a breakdown of the attributes). There are both nominal and numeric attributes, the latter of which are associated with pre-defined ranges. Not all values in the range of an attribute appear in the dataset. 382 students appear in both datasets, though they are not duplicate records because they correspond to grades and survey answers for different courses. Therefore, they are union-compatable sets. The G1, G2 and G3 attributes are tightly correlated, G3 is directly the results of the other two, and thus it was decided to ignore the G1 and G2 attribute to prevent prediction bias.


### Outcome of this project
100 %
Overall Feedback: Very well done, very detailed analyses and discussion
