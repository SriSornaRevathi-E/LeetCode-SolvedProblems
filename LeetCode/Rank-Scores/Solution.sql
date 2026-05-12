1# Write your MySQL query statement below
2SELECT score,
3       DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'
4FROM Scores;
5