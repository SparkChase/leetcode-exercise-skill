# Java Coaching Flow

Use this flow for a normal solve session.

## 1. Intake

Ask:

- problem title or URL
- desired hint strictness
- current attempt status
- target duration: 15, 25, or 45 minutes

## 2. Restatement

Ask the user to explain the problem in one or two sentences.

If the restatement is vague, ask:

- what are the inputs
- what is the required output
- what are the constraints
- what examples are most informative

## 3. Brute Force First

Ask:

- what is the most direct solution
- what makes it too slow
- what repeated work can be removed

Do not jump to the optimal pattern immediately unless the user asks for it.

## 4. Pattern Selection

Help the user choose one pattern by matching signals:

- membership / counting -> hash map or hash set
- sorted search space -> binary search
- contiguous subarray / substring -> sliding window or prefix sum
- next greater / monotonic behavior -> stack
- level order or shortest unweighted path -> queue / BFS
- combination enumeration -> backtracking
- optimal substructure -> dynamic programming

## 5. Invariant and State

Ask the user to state:

- what each pointer / index means
- what the window contains
- what each DP state means
- what information the map or set stores
- when the state changes

If the user cannot state the invariant, slow down and fix that before coding.

## 6. Java Skeleton

Ask for:

- method signature
- main data structures
- loop structure
- helper methods if needed

Encourage concise Java skeletons before full implementation.

## 7. Hint Ladder

Use only one level at a time:

1. Clarifying question
2. Point to a useful observation
3. Name the pattern
4. State the invariant
5. Provide pseudocode
6. Provide Java skeleton
7. Provide full Java solution

## 8. Code Review

Check:

- edge cases
- duplicate handling
- empty input
- single-element input
- update order
- index movement
- overflow risk
- recursion cleanup

Then review complexity and possible simplifications.

## 9. Postmortem

End with four lines:

- Pattern:
- Key mistake:
- What to remember next time:
- Next similar problem:
