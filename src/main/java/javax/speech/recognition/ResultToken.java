package javax.speech.recognition;

/**
 * A token (usually a word) contained by a Result
 * representing something heard by a recognizer.
 * For a result of a RuleGrammar a ResultToken
 * contains the same string as the defining RuleToken in the
 * RuleGrammar.  For a result of a DictationGrammar,
 * the tokens are defined by the recognizer.
 * <p>
 * For any result, best guess finalized tokens are obtained from
 * the getBestToken and getBestTokens
 * methods of the Result interface.  For a finalized
 * result matching a RuleGrammar or a finalized
 * result matching a DictationGrammar alternative
 * guesses are available through the getAlternativeTokens
 * methods of the FinalRuleResult and
 * FinalDictationResult interfaces respectively.
 * <p>
 * The ResultToken provides the following information:
 * <p>
 * Required: Spoken-form text
 * Required: reference to the Result that contains this token
 * Optional: Start and end time
 * Dictation only: Written-form text
 * Dictation only: Presentation hints (capitalization and spacing)
 * <p>
 * <A>Spoken vs. Written Form</A>
 * <p>
 * The distinction between spoken and written forms of a
 * ResultToken applies only to results for a
 * DictationGrammar.  For a result matching a
 * RuleGrammar, the written and spoken forms are identical.
 * <p>
 * The spoken form is a printable string that indicates what the
 * recognizer heard the user say.  In a dictation application,
 * the spoken form is typically used when displaying unfinalized tokens.
 * <p>
 * The written form is a printable string that indicates how
 * the recognizer thinks the token should be printed in text.
 * In a dictation application, the written form is typically used
 * when displaying finalized tokens.
 * <p>
 * For example, in English, a recognizer might return "twenty" for the
 * spoken form and "20" for the written form.
 * <p>
 * Recognizers perform the conversion from spoken to written
 * form on a per-token basis.  For example, "nineteen thirty
 * eight" is three tokens.  The written form would also be
 * three tokens: "19 30 8".  Applications may use additional
 * processing to convert such token sequences to "1938".
 * <p>
 * For some ResultTokens, the written form is a single Unicode
 * character.  Amongst these are the following important
 * formatting characters (shown here as spoken form for US English, written
 * form as a Unicode character number):
 * <p>
 * New line character is "\u000A" and equals the
 * static string NEW_LINE.
 * In English, it might be spoken as "new line", "line break" or similar.
 * New paragraph character is "\u2029" and equals the
 * static string NEW_PARAGRAPH.
 * In English, it might be spoken as "new paragraph",
 * "start paragraph" or something similar.
 * <p>
 * The following are examples of punctuation characters given with
 * sample spoken forms and the corresponding written form.
 * The spoken form may vary between recognizers and one recognizer
 * may even allow one punctuation character to be spoken multiple ways.
 * Also the set of characters may be engine-specific and language-specific.
 * <p>
 * "space bar" -
 * " " (u0020)
 * "exclamation mark", "exclamation point" -
 * "!" (u0021)
 * "open quote", "begin quote", "open-\"" -
 * "\"" (u0022) (single quote char)
 * "dash", "hyphen", "minus" -
 * "-" (u002D)
 * "pound sign" -
 * "�" (u00A3)
 * "yen sign" -
 * "�" (u00A5)
 * <p>
 * <A>Presentation Hints</A>
 * <p>
 * Note: results for rule grammars do not provide presentation hints.
 * Default values are returns for both SpacingHint and
 * CapitalizationHint.
 * <p>
 * Applications use the presentation hints as a guide to
 * rendering the written-form tokens into complete strings.
 * The two hints are SpacingHint and
 * CapitalizationHint.
 * <p>
 * SpacingHint is an int with several
 * flags indicating how the token should be spaced.
 * <p>
 * SpacingHint==SEPARATE
 * (value of 0) when all the flags are false.
 * The token should be surrounding by preceding and following
 * spaces.
 * ATTACH_PREVIOUS:
 * Flag is true if the token should be attached
 * to the previous token: i.e. no space between this token and the previous token.
 * ATTACH_FOLLOWING:
 * Flag is true if the token should be attached
 * to the following token: i.e. no space between this token and the following token.
 * ATTACH_GROUP:
 * If this flag is true and if the ATTACH_GROUP
 * flag for a previous and/or following token is true,
 * then override the other spacing flags and put no space between
 * the tokens in the group.
 * <p>
 * The ATTACH_GROUP is the least obvious flag.  In English,
 * a common use of this flag is for sequence of digits.  If the user says
 * four tokens "3" "point" "1" "4" (point='.'), and these tokens
 * all have the ATTACH_GROUP flag set, then they are joined.
 * The presentation string is "3.14".  The name of the flag implies that
 * tokens in the same "group" should have no spaces between them.
 * <p>
 * "previous" means the previously spoken token in the sequence of tokens -
 * that is, previous in time.  For left-to-right languages (e.g. English, German)
 * ATTACH_PREVIOUS means left attachment - no space to the left.
 * For right-to-left languages (e.g. Arabic, Hebrew) ATTACH_PREVIOUS
 * means right attachment - no space to the right.
 * The converse is true for ATTACH_FOLLOWING.
 * <p>
 * The spacing flags are OR'ed (Java '|' operator on integers).
 * A legal value might be (ATTACH_PREVIOUS | ATTACH_FOLLOWING).
 * The SEPARATE value is 0 (zero).
 * A flag can be tested by the following code:
 * <p>
 * // if attach previous ...
 * if ((token.getSpacingHint() & ResultToken.ATTACH_PREVIOUS) != 0)
 * ...
 * <p>
 * capitalizationHint indicates how the written form
 * of the following token should be capitalized.  The options are
 * <p>
 * CAP_AS_IS:
 * As-is indicates the capitalization of the spoken form of
 * the following should not be changed
 * CAP_FIRST:
 * Capitalize first character of the spoken form of the following token
 * UPPERCASE: All uppercase following token
 * LOWERCASE: All lowercase following token
 * <p>
 * The Internationalized case conversion methods of the java.lang.String
 * are recommended for implementing the capitalization hints.
 * <p>
 * <A>Null Written Form</A>
 * <p>
 * Some spoken directives to recognizers produce tokens that have
 * no printable form.  These tokens return null for the written form.
 * Typically, these directives give explicit capitalization or
 * spacing hints.  The spoken forms of these tokens should be
 * non-null (to allow the application to provide appropriate feedback
 * to a user.  Example directives for English might include:
 * <p>
 * "Capitalize next", "Cap next", "Upper case"
 * "Lowercase"
 * "Uppercase"
 * "No space"
 * <p>
 * For these tokens, the interpretation of the capitalization and
 * spacing hints is specialized.  If the spacing hint
 * differs from the default, SEPARATE, it overrides
 * the spacing hint of the next non-null token.
 * If the capitalization hint differs from the default,
 * CAP_AS_IS, it overrides the capitalization hints of
 * previous non-null token (which in fact applies to the following
 * token also).
 * <p>
 * <A>Example</A>
 * <p>
 * This example shows how a string of result tokens should
 * be processed to produce a single printable string.
 * The following is a sequence of tokens in a FinalDictationResult
 * shown as spoken form, written form, and spacing and capitalization hints.
 * <p>
 * "NEW_LINE", "\u000A", SEPARATE, CAP_FIRST
 * "the", "the", SEPARATE, CAP_AS_IS
 * "UPPERCASE_NEXT", "", SEPARATE, UPPERCASE
 * "index", "index", SEPARATE, CAP_AS_IS
 * "is", "is" SEPARATE, CAP_AS_IS
 * "seven", "7", ATTACH_GROUP, CAP_AS_IS
 * "-", "-", ATTACH_GROUP, CAP_AS_IS
 * "two", "2", ATTACH_GROUP, CAP_AS_IS
 * "period", ".", ATTACH_PREVIOUS, CAP_FIRST
 * <p>
 * that could be converted to "\nThe INDEX is 7-2."
 *
 * @see javax.speech.recognition.Result
 * @see javax.speech.recognition.FinalResult
 * @see javax.speech.recognition.FinalDictationResult
 * @see javax.speech.recognition.FinalRuleResult
 */
public interface ResultToken {

    /**
     * Special token representing the written form of
     * the "New Paragraph" directive.  Equal to "\u2029".
     * The spoken form of a "New Paragraph" directive
     * may vary between recognizers.
     */
   String NEW_PARAGRAPH = "\u2029";

    /**
     * Special token representing the written form of
     * the "New Line" directive.  Equal to "\\n".
     * The spoken form of a "New Line" directive
     * may vary between recognizers.
     */
   String NEW_LINE = "\n";

    /**
     * A SpacingHint returned when a token should be
     * presented separately from surrounding tokens (preceding and
     * following spaces).  Returned when
     * ATTACH_PREVIOUS,
     * ATTACH_FOLLOWING,
     * and ATTACH_GROUP are all false.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     * <p>
     * SEPARATE is the default spacing hint value.
     * <p>
     * Example:
     * <p>
     * if (resultToken.getSpacingHint() == ResultToken.SEPARATE)
     * ...;
     *
     * @see javax.speech.recognition.ResultToken#getSpacingHint()
     */
   int SEPARATE = 0;

    /**
     * A SpacingHint flag set true when a token should be
     * attached to the preceding token.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     * <p>
     * Example:
     * <p>
     * if ((resultToken.getSpacingHint() & ResultToken.ATTACH_PREVIOUS) != 0)
     * ...;
     *
     * @see javax.speech.recognition.ResultToken#getSpacingHint()
     */
   int ATTACH_PREVIOUS = 1;

    /**
     * A SpacingHint flag set true when a token should be
     * attached to the following token.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     * <p>
     * Example:
     * <p>
     * if ((resultToken.getSpacingHint() & ResultToken.ATTACH_FOLLOWING) != 0)
     * ...;
     *
     * @see javax.speech.recognition.ResultToken#getSpacingHint()
     */
   int ATTACH_FOLLOWING = 2;

    /**
     * A SpacingHint flag set true when a token should be
     * attached to preceding and/or following tokens which also have the
     * ATTACH_GROUP flag set true.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     * <p>
     * Example:
     * <p>
     * if (((thisToken.getSpacingHint() & ResultToken.ATTACH_GROUP) != 0)
     * && ((prevToken.getSpacingHint() & ResultToken.ATTACH_GROUP) != 0))
     * ...;
     *
     * @see javax.speech.recognition.ResultToken#getSpacingHint()
     */
   int ATTACH_GROUP = 4;

    /**
     * A CapitalizationHint indicating that the following word
     * should be presented without changes in capitalization.
     * This is the default value.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     */
   int CAP_AS_IS = 10;

    /**
     * A CapitalizationHint indicating that the following word
     * should be presented with the first character in uppercase.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     */
   int CAP_FIRST = 11;

    /**
     * A CapitalizationHint indicating that the following word
     * should be presented in uppercase.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     */
   int UPPERCASE = 12;

    /**
     * A CapitalizationHint indicating that the following word
     * should be presented in lowercase.
     * (See the
     * <A href="#Presentation">description</A>
     * above.)
     */
   int LOWERCASE = 13;

    /**
     * Get the capitalization hint. (See
     * <A href="#Presentation">description</A>
     * above.)
     * Values are CAP_AS_IS (the default),
     * CAP_FIRST,
     * UPPERCASE,
     * LOWERCASE.
     * Tokens from a RuleGrammar result always return CAP_AS_IS.
     */
   int getCapitalizationHint();

    /**
     * Get the approximate end time for the token.
     * The value is matched to the
     * System.currentTimeMillis() time.
     * <p>
     * The end time of a token is always less than or equal to the
     * the end time of a preceding token.  The values will be different
     * if the tokens are separated by a pause.
     * <p>
     * Returns -1 if timing information is not available.
     * Not all recognizers provide timing information.
     * Timing information is not usually available for unfinalized or
     * finalized tokens in a Result that is not yet finalized.
     * Even if timing information is available for the best-guess tokens,
     * it might not be available for alternative tokens.
     *
     * @see java.lang.System#currentTimeMillis()
     */
   long getEndTime();

    /**
     * Return a reference to the result that contains this token.
     */
   Result getResult();

    /**
     * Get the spacing hints. (See
     * <A href="#Presentation">description</A>
     * above.)
     * The value equals SEPARATE (the default) if
     * the token should be presented with surrounding spaces.
     * Otherwise any or all of the following flags can be true:
     * ATTACH_FOLLOWING,
     * ATTACH_PREVIOUS,
     * ATTACH_GROUP.
     * Tokens from a RuleGrammar result always return SEPARATE.
     */
   int getSpacingHint();

    /**
     * Get the spoken text of a token.  In dictation, the spoken form
     * is typically used when displaying unfinalized tokens.
     * The
     * <A href="#Spoken_Written">difference between spoken and written forms</A>
     * is discussed above.
     */
   String getSpokenText();

    /**
     * Get the approximate start time for the token.
     * The value is matched to the
     * System.currentTimeMillis() time.
     * <p>
     * The start time of a token is always greater than or equal to the
     * the end time of a preceding token.  The values will be different
     * if the tokens are separated by a pause.
     * <p>
     * Returns -1 if timing information is not available.
     * Not all recognizers provide timing information.
     * Timing information is not usually available for unfinalized or
     * finalized tokens in a Result that is not yet finalized.
     * Even if timing information is available for the best-guess tokens,
     * it might not be available for alternative tokens.
     *
     * @see java.lang.System#currentTimeMillis()
     */
   long getStartTime();

    /**
     * Get the written form of a spoken token.
     * <p>
     * <A href="#Spoken_Written">Spoken and written forms</A>
     * are discussed above.
     */
   String getWrittenText();
}
