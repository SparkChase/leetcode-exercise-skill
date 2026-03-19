# Problem Source Policy

Use problem sources that are safe, maintainable, and likely to comply with the platform's rules.

Prefer these sources:

1. Official LeetCode study plans and problem list pages.
2. Exact problem titles or URLs provided by the user.
3. Problem summaries, examples, and constraints pasted by the user.
4. The user's own notes, screenshots, bookmarks, or progress list.

Avoid these patterns:

1. Scraping the full site or mirroring the entire problem bank.
2. Building a local archive of copied problem statements.
3. Reproducing large portions of copyrighted statements when a short summary is enough.
4. Depending on undocumented internal endpoints as the core data source.

If the user wants a reusable dataset for practice tracking, store only metadata:

- title
- url
- difficulty
- tags
- source plan
- solved status
- retry count
- mistakes
- learned pattern
- review date

When the user gives only a title or URL:

1. Ask the user to paste the key examples and constraints if needed.
2. If the user does not want to paste the full statement, ask for a short restatement.
3. Continue coaching from that summary.

When the user asks whether to "directly scrape" LeetCode:

- advise against it
- say the safer design is a coaching skill, not a statement-harvesting skill
- use official study plans or user-provided inputs as the intake source
