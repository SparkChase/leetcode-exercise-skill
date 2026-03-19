# Top 100 Liked Rhythm

Use this mode when the user says the practice source is fixed to the official LeetCode Top 100 Liked study plan:

- official page: https://leetcode.cn/studyplan/top-100-liked/
- source policy: use the official page as the index, and use problem titles, URLs, or the user's pasted summaries during sessions

## Daily Rhythm

Default interpretation:

- 10 new problems per day
- after every 3 new problems, revisit 1 previously solved problem

That produces this cycle:

1. new 1
2. new 2
3. new 3
4. review 1 old problem
5. new 4
6. new 5
7. new 6
8. review 2 old problem
9. new 7
10. new 8
11. new 9
12. review 3 old problem
13. new 10

If the user later says "10 total slots including review", switch to:

- 8 new problems
- 2 review problems

## Review Rule

When choosing a review problem, prefer one of these:

1. a problem solved incorrectly first time
2. a problem whose pattern was not recognized quickly
3. a problem with messy Java implementation
4. a problem not reviewed for at least 3 days

During review, do not fully re-study the editorial. Ask the user to do one of:

- restate the pattern in one sentence
- write the core invariant
- code the solution from scratch in Java
- explain the previous bug

## Session Template

For each new problem:

1. title or URL
2. difficulty
3. target time
4. user's brute-force idea
5. chosen pattern
6. Java skeleton
7. final complexity
8. one-line takeaway

For each review problem:

1. why it is being reviewed
2. pattern recall
3. previous mistake
4. whether the user can code it faster now

## Tracking Recommendation

Track only lightweight metadata:

- sequence number in the plan
- title
- difficulty
- tags
- first-pass result
- time spent
- review count
- last mistake
- next review date
