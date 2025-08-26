Problem Description

You’re building an input validator for a form where users type numbers. The field should accept:

Integers: "10", "-10"

Decimal numbers: "10.1", "-10.1", ".5", "3."

Scientific notation: "1e5", "-3.2E-7"

It should reject malformed inputs such as: "a", "x 1", "a -2", "-", "1e", "e9".

Rules:

Leading/trailing spaces are allowed, internal spaces are not.

Leading sign (+/-) is optional.

For scientific notation, e/E must be followed by an integer (with optional sign).

Decimal point can appear at most once and cannot appear after e/E.

Input: A single string s.
Output: Return true if s represents a valid number, else false.

Constraints:

1 ≤ len(s) ≤ 10^4

Characters include digits 0-9, signs +/-, decimal point ., exponent e/E, and spaces.

No thousands separators.

Approach 1: Regex-based Validation

Use a single regular expression pattern to validate the number.

Handles optional spaces, signs, decimal points, and scientific notation.

Advantages: Very concise and easy to implement.

Disadvantages: Harder to debug if the pattern is wrong; may not be intuitive for beginners.

Regex pattern idea:

Optional leading/trailing spaces: ^\s*...\s*$

Optional sign: [+-]?

Digits with optional decimal: (\d+(\.\d*)?|\.\d+)

Optional exponent: (e[+-]?\d+)?
---------------------
Approach 2: State Machine / Manual Parsing

Parse the string character by character.

Track flags: seenDigit, seenDot, seenE.

Ensure proper order: [sign] digits [dot digits] [e/E [sign] digits]

Advantages: More control, easy to handle corner cases.

Disadvantages: Slightly longer code; more state management.
---------------------------------------------------
Approach 3: Language Built-in Parsing (Java Example)

Use Double.parseDouble(s.trim()) to check if the string converts to a number.

Wrap in try/catch to handle invalid strings.

Advantages: Simple, leverages language capabilities.

Disadvantages: May accept slightly invalid formats that you don't want.
