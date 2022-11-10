# Election-Voting-Project
# Code Written By: 
1. Pratik Pradhan
2. Savani Kalekar
3. Aditya Wadkar

Problem Statement:

The Election Commission of India announces assembly elections for Maharashtra state. Amid the Covid surge, for the convenience of voters, the election commission has increased the number of voting booths. The system has also been modernized to share the result in the evening, by the end of the day. However, every voter is allowed to vote only once. Voters should only vote at the constituency where they have registered themselves. On election day evening, the results will be announced. 

Following are the points to be considered.
X candidates are contesting for the election from Y constituencies.
There are Z polling stations throughout the state. 
P number of citizens will be voting this year for the election. 
Voters can utilize the power of NOTA (None of the above). This option enables the voter to officially register a rejection vote for all contestants.
If NOTA receives the highest number of votes, the winner will be the candidate who receives the second-highest number of votes.
A candidate cannot contest from more than one constituency.
If individual votes more than once, the system will disqualify all the votes cast by that voter.
Per constituency, only one candidate will be elected.
In case of a tie in the constituency, the result will be "NO_WINNER" for that constituency.
Candidate list in the result should be ordered by count and name in the same precedence.
NOTA count should always appear in the result in the last.

Write an efficient system to conduct elections and announce the result at the end of the day. 

Input
candidateFile.csv : 
Contains the list of candidates from each constituency
votingFile.csv
Contains the votes cast by the individuals
Output
ElectionResult Object
Contains the constituency-wise winners

Limits/Constraints
X  >= 200
Y  >= 10
Z  >= 1400
P  >= 2 mn







