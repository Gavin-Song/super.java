/**
 * SuperString class - duplicates and extends
 * the functionality of String. See https://github.com/Gavin-Song/super.java/wiki/SuperString
 * for wiki
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.nio.charset.Charset;
import java.math.BigDecimal;


/**
 * <h1>SuperString</h1>
 * Duplicates and extends the default functionality of a string.
 * Many common methods are implemented, for ease of use. To create
 * a SuperString, simply do<br>
 * {@code SuperString s = new SuperString("Some string here");}
 *
 * @author  Gavin Song
 * @version 1.0.0
 * @since   2018-02-15
 */
public class SuperString implements Comparable,
        Iterable < SuperString > , CharSequence {

    /* Static variables */
    public static final String VERSION = "1.0.0";
    public static final SuperString[] punc =
            new SuperString(".,-/#!$%^&*;:{}=-_`~(\\").toSuperStringArray();
    public static final String[] punc_string =
            new SuperString(".,-/#!$%^&*;:{}=-_`~(\\").toStringArray();
    public static final SuperString alphabet =
            new SuperString("abcdefghijklmnopqrstuvwxyz");
    public static final SuperString alphabet_upper =
            new SuperString("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    public static final String alphabet_string =
            "abcdefghijklmnopqrstuvwxyz";
    public static final String alphabet_upper_string =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /* Instance variables */
    public final String str;
    public final int length;

    /* Constructors. Note that you can create a
     * SuperString with any Object type, in which
     * case it will automatically be converted
     * to a String */
    SuperString(Object s) {
        this.str = s.toString();
        this.length = this.str.length();
    }
    SuperString(boolean s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(byte s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(char s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(short s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(int s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(long s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(float s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }
    SuperString(double s) {
        this.str = String.valueOf(s);
        this.length = this.str.length();
    }


    /**
     * Converts the SuperString to a String[], where each
     * character is an element in the array.
     *
     * Ex: {@code "test" -> {"t", "e", "s", "t"}}
     * @return String[] A string array of each character in the String
     */
    public String[] toStringArray() {
        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++)
            arr[i] = String.valueOf(str.charAt(i));
        return arr;
    }

    /**
     * Converts the SuperString to a SuperString[], where each
     * character is an element in the array.
     *
     * Ex: {@code "test" -> {"t", "e", "s", "t"}}
     * @return SuperString[] A SuperString array of each character in the String
     */
    public SuperString[] toSuperStringArray() {
        return SuperString.StringArrToSuperStringArr(this.toStringArray());
    }

    /* --- Duplicating String functionality --- */
    public char charAt(int i) {
        if (i < 0) i = this.length + i;
        return this.str.charAt(i);
    }
    public int codePointAt(int i) {
        return this.str.codePointAt(i);
    }
    public int codePointBefore(int i) {
        return this.str.codePointBefore(i);
    }
    public int codePointCount(int i1, int i2) {
        return this.str.codePointCount(i1, i2);
    }
    public int compareTo(Object o) {
        return this.str.compareTo(o.toString());
    }
    public int compareToIgnoreCase(Object o) {
        return this.str.compareToIgnoreCase(o.toString());
    }
    public SuperString concat(String s) {
        return new SuperString(this.str + s);
    }
    public boolean contains(CharSequence s) {
        return this.str.contains(s);
    }
    public boolean contentEquals(CharSequence cs) {
        return this.str.contentEquals(cs);
    }
    public boolean endsWith(String s) {
        return this.str.endsWith(s);
    }
    public byte[] getBytes() {
        return this.str.getBytes();
    }
    public byte[] getBytes(Charset charset) {
        return this.str.getBytes(charset);
    }
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        this.str.getChars(srcBegin, srcEnd, dst, dstBegin);
    }
    public int indexOf(int i) {
        return this.str.indexOf(i);
    }
    public int indexOf(int i, int s) {
        return this.str.indexOf(i, s);
    }
    public int indexOf(String i) {
        return this.str.indexOf(i);
    }
    public int indexOf(String i, int s) {
        return this.str.indexOf(i, s);
    }

    public String intern() {
        return this.str.intern();
    }
    public boolean isEmpty() {
        return this.str.isEmpty();
    }
    public boolean isBlank() {
        return this.isEmpty();
    }

    public int lastIndexOf(int i) {
        return this.str.lastIndexOf(i);
    }
    public int lastIndexOf(int i, int s) {
        return this.str.lastIndexOf(i, s);
    }
    public int lastIndexOf(String i) {
        return this.str.lastIndexOf(i);
    }
    public int lastIndexOf(String i, int s) {
        return this.str.lastIndexOf(i, s);
    }

    public int length() {
        return this.str.length();
    }
    public boolean matches(String r) {
        return this.str.matches(r);
    }
    public int offsetByCodePoints(int index, int codePointOffset) {
        return this.str.offsetByCodePoints(index, codePointOffset);
    }
    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return this.str.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }
    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return this.str.regionMatches(toffset, other, ooffset, len);
    }
    public String replaceString(char oldChar, char newChar) {
        return this.str.replace(oldChar, newChar);
    }
    public String replaceString(CharSequence target, CharSequence replacement) {
        return this.str.replace(target, replacement);
    }
    public String replaceAllString(String regex, String replacement) {
        return this.str.replaceAll(regex, replacement);
    }
    public String replaceFirstString(String regex, String replacement) {
        return this.str.replaceFirst(regex, replacement);
    }
    public String replaceLastString(char oldChar, char newChar) {
        return this.str.replaceAll(SuperString.escapeRegexString(String.valueOf(oldChar)) + "$", String.valueOf(newChar));
    }
    public String replaceLastString(CharSequence target, CharSequence replacement) {
        return this.str.replaceAll(SuperString.escapeRegexString(String.valueOf(target)) + "$", String.valueOf(replacement));
    }

    public String[] splitString(String r) {
        return this.str.split(r);
    }
    public String[] splitString(String r, int i) {
        return this.str.split(r, i);
    }

    public boolean startsWith(String s) {
        return this.str.startsWith(s);
    }
    public boolean startsWith(String s, int i) {
        return this.str.startsWith(s, i);
    }
    public CharSequence subSequence(int beginIndex, int endIndex) {
        return this.str.subSequence(beginIndex, endIndex);
    }

    /**
     * Returns a substring, from i to the end of the string. If i
     * is negative, the index counts backwards (Like python indices)
     *
     * @param i Index to start at
     * @return Substring
     */
    public String substringString(int i) {
        /* If i is negative, make it count backwards
         * from the end of the string */
        if (i < 0) i = this.length + i;
        return this.str.substring(i);
    }
    /**
     * Returns a substring, from i1 to i2. If i1 or i2
     * are negative, the index counts backwards (Like python indices)
     *
     * @param i1 Index to start at
     * @param i2 Index to send at
     * @return Substring
     */
    public String substringString(int i1, int i2) {
        /* If i1 or i2 is negative, make it count backwards
         * from the end of the string */
        if (i1 < 0) i2 = this.length + i1;
        if (i2 < 0) i2 = this.length + i2;
        return this.str.substring(i1, i2);
    }

    public char[] toCharArray() {
        return this.str.toCharArray();
    }

    public String toLowerCaseString() {
        return this.str.toLowerCase();
    }
    public String toLowerCaseString(Locale l) {
        return this.str.toLowerCase(l);
    }
    public String toUpperCaseString() {
        return this.str.toUpperCase();
    }
    public String toUpperCaseString(Locale l) {
        return this.str.toUpperCase(l);
    }
    public String trimString() {
        return this.str.trim();
    }
    public String stripString() {
        return this.trimString();
    }


    /* --- String functionality, but with SuperString --- */
    public SuperString concat(SuperString s) {
        return new SuperString(this.str + s.toString());
    }
    public boolean endsWith(SuperString s) {
        return this.str.endsWith(s.toString());
    }
    public SuperString replace(char oldChar, char newChar) {
        return new SuperString(this.str.replace(oldChar, newChar));
    }
    public SuperString replace(CharSequence target, CharSequence replacement) {
        return new SuperString(this.str.replace(target, replacement));
    }
    public SuperString replaceAll(String regex, String replacement) {
        return new SuperString(this.str.replaceAll(regex, replacement));
    }
    public SuperString replaceFirst(String regex, String replacement) {
        return new SuperString(this.str.replaceFirst(regex, replacement));
    }
    public SuperString replaceLast(char oldChar, char newChar) {
        return new SuperString(this.replaceLastString(oldChar, newChar));
    }
    public SuperString replaceLast(CharSequence target, CharSequence replacement) {
        return new SuperString(this.replaceLastString(target, replacement));
    }

    public SuperString[] split(String r) {
        String[] temp = this.splitString(r);
        return SuperString.StringArrToSuperStringArr(temp);
    }
    public SuperString[] split(String r, int x) {
        String[] temp = this.splitString(r, x);
        return SuperString.StringArrToSuperStringArr(temp);
    }
    public SuperString[] split(SuperString r) {
        return this.split(r.toString());
    }
    public SuperString[] split(SuperString r, int i) {
        return this.split(r.toString(), i);
    }

    public boolean startsWith(SuperString s) {
        return this.str.startsWith(s.toString());
    }
    public boolean startsWith(SuperString s, int i) {
        return this.str.startsWith(s.toString(), i);
    }

    public SuperString substring(int i) {
        return new SuperString(this.substringString(i));
    }
    public SuperString substring(int i1, int i2) {
        return new SuperString(this.substringString(i1, i2));
    }

    public SuperString toUpperCase() {
        return new SuperString(this.toUpperCaseString());
    }
    public SuperString toLowerCase() {
        return new SuperString(this.toLowerCaseString());
    }
    public SuperString toUpperCase(Locale l) {
        return new SuperString(this.toUpperCaseString(l));
    }
    public SuperString toLowerCase(Locale l) {
        return new SuperString(this.toLowerCaseString(l));
    }
    public SuperString trim() {
        return new SuperString(this.trimString());
    }
    public SuperString strip() {
        return this.trim();
    }


    /* --- Additional functionality --- */

    /**
     * Given 2 strings, returns the string between the first
     * 2 occurrences of said strings. For example,
     *      {@code betweenString("<a>", "</a>")} for {@code "<a>test</a>"}
     * would return "test"
     *
     * Does not return an empty string if a equals b, for example
     *      {@code betweenString("t", "t")} for {@code "test"}
     * returns "es" as expected
     *
     * This method is overloaded so a and b can also be inputted
     * as SuperString objects
     *
     * @param a First string to match between
     * @param b Second string to match between
     * @return String String between a and b
     */
    public String betweenString(String a, String b) {
        int i1 = this.str.indexOf(a);
        int i2 = this.str.indexOf(b, i1 + 1);

        if (i2 == -1) i2 = this.length;

        return this.str.substring(i1 + 1, i2);
    }
    public String betweenString(SuperString a, SuperString b) {
        return betweenString(a.toString(), b.toString());
    }

    /**
     * Given 2 strings, returns the SuperString between a and b. This
     * method is overloaded so a and b can also be inputted as SuperStrings.
     * Besides return type, between is functionally identical to betweenString
     *
     * @param a First string to match between
     * @param b Second string to match between
     * @return SuperString SuperString between a and b
     */
    public SuperString between(String a, String b) {
        return new SuperString(betweenString(a, b));
    }
    public SuperString between(SuperString a, SuperString b) {
        return new SuperString(betweenString(a, b));
    }

    /**
     * Returns the substring before the first occurrence of a.
     * Overloaded to accept both String and SuperString
     *
     * @param a String to substring before
     * @exception IndexOutOfBoundsException Thrown when a is not present
     * @return Substring
     */
    public String beforeString(String a) {
        int i = this.str.indexOf(a);
        if (i == -1) i = this.length;
        return this.str.substring(0, i);
    }
    public String beforeString(SuperString a) {
        return this.beforeString(a.toString());
    }

    /**
     * Returns the substring before the first occurrence of a.
     * Overloaded to accept both String and SuperString
     *
     * @param a String to substring before
     * @exception IndexOutOfBoundsException Thrown when a is not present
     * @return Substring
     */
    public SuperString before(String a) {
        return new SuperString(this.beforeString(a));
    }
    public SuperString before(SuperString a) {
        return new SuperString(this.beforeString(a));
    }

    /**
     * Returns the substring after the first occurrence of a.
     * Overloaded to accept both String and SuperString
     *
     * @param a String to substring after
     * @exception IndexOutOfBoundsException Thrown when a is not present
     * @return Substring
     */
    public String afterString(String a) {
        int i = this.str.indexOf(a);
        return this.str.substring(i + 1);
    }
    public String afterString(SuperString a) {
        return this.afterString(a.toString());
    }

    /**
     * Returns the substring after the first occurrence of a.
     * Overloaded to accept both String and SuperString
     *
     * @param a String to substring after
     * @exception IndexOutOfBoundsException Thrown when a is not present
     * @return Substring
     */
    public SuperString after(String a) {
        return new SuperString(this.afterString(a));
    }
    public SuperString after(SuperString a) {
        return new SuperString(this.afterString(a));
    }


    /**
     * Capitalizes a string (First char is uppercase, rest are lowercase)
     * Ex: {@code "heLLo" -> "Hello"}
     * @return String capitalized string
     */
    public String capitalizeString() {
        if (this.length == 0) // Handle empty strings
            return "";
        return this.str.substring(0, 1).toUpperCase() + this.str.substring(1).toLowerCase();
    }

    /**
     * Capitalizes a string, and returns a SuperString object
     * Functionally identical to capitalizeString other than return type
     * @return SuperString capitalized string
     */
    public SuperString capitalize() {
        return new SuperString(this.capitalizeString());
    }

    /**
     * Uncapitalizes a string (First char is lowercase, rest are ignored)
     * Ex: {@code "HeLLo" -> "heLLo"}
     * @return String uncapitalized string
     */
    public String uncapitalizeString() {
        if (this.length == 0) // Handle empty strings
            return "";
        return this.str.substring(0, 1).toLowerCase() + this.str.substring(1);
    }

    /**
     * Uncapitalizes a string, and returns a SuperString object
     * Functionally identical to uncapitalizeString other than return type
     * @return SuperString uncapitalized string
     */
    public SuperString uncapitalize() {
        return new SuperString(this.uncapitalizeString());
    }

    /**
     * Title cases a string, capitalizing the first letter of each
     * word. For example, {@code "tEsT pHrAsE".titleCaseString() -> "Test Phrase"}
     * Different from capitalize, which only capitalizes the first letter of the
     * entire string.
     *
     * @return Titlecased string
     */
    public String titleCaseString() {
        String returned = "";
        String[] words = this.str.split(" ");
        for (String word: words) {
            returned += word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
        }

        /* Remove the trailing whitespace */
        returned = returned.substring(0, returned.length() - 1);
        return returned;
    }

    /**
     * Functionally identical to titleCaseString, but returns a SuperString instead.
     * @return Titlecased string
     */
    public SuperString titleCase() {
        return new SuperString(this.titleCaseString());
    }

    /**
     * Converts a string to CamelCase, splitting along dashes and underscores.
     * For example, {@code "cool_string-example" -> "CoolStringExample"}
     * @return camelized string
     */
    public String camelizeString() {
        /* Split the string along each dash and underscore */
        String[] substrs = this.str.replaceAll("-", "|")
                .replaceAll("_", "|").split("\\|");

        /* To camelcase, take each substring and capitalize the first letter,
         * while lower casing everything else */
        String returned = "";
        for (String substr: substrs) {
            returned += substr.substring(0, 1).toUpperCase() + substr.substring(1).toLowerCase();
        }
        return returned;
    }

    /**
     * Converts a string to CamelCase. Functionally same as camelizeString, but
     * returns a SuperString instead.
     * @return camelized string
     */
    public SuperString camelize() {
        return new SuperString(this.camelizeString());
    }

    /**
     * Converts a string from CamelCase to underscore case.
     * @return underscored string
     */
    public String underscoreString() {
        return this.str.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
    }

    /**
     * Same as underscoreString, but returns SuperString
     * @return underscored string
     */
    public SuperString underscore() {
        return new SuperString(this.underscoreString());
    }

    /**
     * Ensures the left of the string starts with prefix.
     * If it doesn't it adds the prefix to the left of
     * the string.
     *
     * @param prefix
     * @return
     */
    public String ensureLeftString(String prefix) {
        return this.str.startsWith(prefix) ?
                this.str : prefix + this.str;
    }
    public String ensureLeftString(SuperString prefix) {
        return this.ensureLeftString(prefix.toString());
    }
    public SuperString ensureLeft(String prefix) {
        return new SuperString(this.ensureLeftString(prefix));
    }
    public SuperString ensureLeft(SuperString prefix) {
        return new SuperString(this.ensureLeftString(prefix.toString()));
    }

    /**
     * Ensures the right of the string starts with suffix.
     * If it doesn't it adds the prefix to the right of
     * the string.
     *
     * @param suffix
     * @return
     */
    public String ensureRightString(String suffix) {
        return this.str.endsWith(suffix) ?
                this.str : this.str + suffix;
    }
    public String ensureRightString(SuperString suffix) {
        return this.ensureRightString(suffix.toString());
    }
    public SuperString ensureRight(String suffix) {
        return new SuperString(this.ensureRightString(suffix));
    }
    public SuperString ensureRight(SuperString suffix) {
        return new SuperString(this.ensureRightString(suffix.toString()));
    }



    /**
     * Trims whitespace from the beginning of the string
     * @return trimmed string
     */
    public String trimLeftString() {
        return this.str.replaceFirst("^\\s+", "");
    }

    /**
     * Trims whitespace from the beginning of the string. Same as
     * trimLeftString, but returns SuperString
     * @return trimmed string
     */
    public SuperString trimLeft() {
        return new SuperString(this.trimLeftString());
    }

    /**
     * Trims whitespace from the end of the string
     * @return trimmed string
     */
    public String trimRightString() {
        return this.str.replaceAll("\\s+$", "");
    }

    /**
     * Trims whitespace from the end of the string. Same as
     * trimLeftString, but returns SuperString
     * @return trimmed string
     */
    public SuperString trimRight() {
        return new SuperString(this.trimRightString());
    }

    /**
     * Returns the string with case swapped, ie uppercase ->
     * lowercase and lowercase -> uppercase
     * @return Swapped case string
     */
    public String swapCaseString() {
        String returned = "";
        for (int i = 0; i < this.str.length(); i++) {
            String c = this.str.substring(i, i + 1);
            returned += c.toLowerCase().equals(c) ?
                    c.toUpperCase() : c.toLowerCase();
        }
        return returned;
    }

    /**
     * Returns the string with case swapped. Same as swapCaseString,
     * but returns a SuperString
     * @return Swapped case string
     */
    public SuperString swapCase() {
        return new SuperString(this.swapCaseString());
    }

    /**
     * Takes the first letter of each word and returns the uppercased string.
     * For example, {@code "A cool phrase".initalsString() -> "ACP"}
     * @return Initals
     */
    public String initalsString() {
        String[] words = this.str.split(" ");
        String returned = "";
        for (String word: words) {
            returned += word.substring(0, 1).toUpperCase();
        }
        return returned;
    }

    /**
     * Functionally identical to initalsString, but returns a SuperString
     * @return initals
     */
    public SuperString initals() {
        return new SuperString(this.initalsString());
    }

    /**
     * Removes String prefix from the beginning of the string, if it
     * exists. For example, {@code "R2-D2".chompLeftString("R2") -> "-D2"}
     *
     * If prefix is not present at the beginning of the string, it returns
     * the string unchanged. Method is overloaded so prefix can be either a
     * String or a SuperString.
     *
     * @param prefix String prefix to remove
     * @return Chomped string
     */
    public String chompLeftString(String prefix) {
        if (this.str.startsWith(prefix))
            return this.str.substring(prefix.length());
        return this.str;
    }
    public String chompLeftString(SuperString prefix) {
        return this.chompLeftString(prefix.toString());
    }

    /**
     * Removes the string prefix from the beginning of the string - functionally identical
     * to chompLeftString, but returns a SuperString. Method is overloaded so prefix can be either a
     * String or a SuperString.
     *
     * @param prefix String prefix to remove
     * @return Chomped string
     */
    public SuperString chompLeft(String prefix) {
        return new SuperString(this.chompLeftString(prefix));
    }
    public SuperString chompLeft(SuperString prefix) {
        return new SuperString(this.chompLeftString(prefix));
    }

    /**
     * Removes String suffix from the end of the string, if it
     * exists. For example, {@code "R2-D2".chompRightString("D2") -> "R2-"}
     *
     * If suffix is not present at the end of the string, it returns
     * the string unchanged. Method is overloaded so suffix can be either a
     * String or a SuperString.
     *
     * @param suffix String suffix to remove
     * @return Chomped string
     */
    public String chompRightString(String suffix) {
        if (this.str.endsWith(suffix))
            return this.str.substring(0, this.length - suffix.length());
        return this.str;
    }
    public String chompRightString(SuperString suffix) {
        return this.chompRightString(suffix.toString());
    }

    /**
     * Truncates string to length, the suffix end_char. Default
     * suffix is "..."
     *
     * @param length Target length
     * @param suffix Suffix
     * @return Truncated string
     */
    public String truncateString(int length, String suffix) {
        if (this.length <= length) return this.str;
        return this.str.substring(0, length - suffix.length() + 1) + suffix;
    }
    public String truncateString(int length, SuperString suffix) {
        return this.truncateString(length, suffix.toString());
    }
    public String truncateString(int length) {
        return this.truncateString(length, "...");
    }

    /**
     * Functionally identical to truncateString, but returns a
     * SuperString instead.
     *
     * @param length Target length
     * @param suffix Suffix
     * @return Truncated string
     */
    public SuperString truncate(int length, String suffix) {
        return new SuperString(this.truncateString(length, suffix));
    }
    public SuperString truncate(int length, SuperString suffix) {
        return new SuperString(this.truncateString(length, suffix));
    }
    public SuperString truncate(int length) {
        return new SuperString(this.truncateString(length, "..."));
    }

    /**
     * Returns the String (character) at a given index
     * @param index
     * @return String at index
     */
    public String getStringAt(int index) {
        if (index < 0) index = this.length + index;
        return this.str.substring(index, index + 1);
    }

    /**
     * Returns the SuperString (character) at a given index
     * @param index
     * @return SuperString at index
     */
    public SuperString getSuperStringAt(int index) {
        if (index < 0) index = this.length + index;
        return new SuperString(this.str.substring(index, index + 1));
    }


    /**
     * Removes the string suffix from the end of the string - functionally identical
     * to chompRightString, but returns a SuperString. Method is overloaded so suffix can be either a
     * String or a SuperString.
     *
     * @param suffix String suffix to remove
     * @return Chomped string
     */
    public SuperString chompRight(String suffix) {
        return new SuperString(this.chompRightString(suffix));
    }
    public SuperString chompRight(SuperString suffix) {
        return new SuperString(this.chompRightString(suffix));
    }

    /**
     * Removes all duplicate whitespace in a string, replacing them with
     * a single space. For example,
     * {@code "test    test \n test".collapseWhitespaceString() -> "test test test"}
     *
     * @return String with duplicate whitespace collapsed
     */
    public String collapseWhitespaceString() {
        return this.str.replaceAll("\\s+", " ");
    }
    public String collapseWhiteSpaceString() {
        return this.collapseWhitespaceString();
    }

    /**
     * Removes all duplicate whitespace in a string, replacing them with
     * a single space. Functionally identical to collpseWhitespaceString, but
     * returns a SuperString.
     *
     * @return String with duplicate whitespace collapsed
     */
    public SuperString collapseWhitespace() {
        return new SuperString(this.collapseWhitespaceString());
    }
    public SuperString collapseWhiteSpace() {
        return new SuperString(this.collapseWhitespaceString());
    }

    /**
     * Counts the number of times substring occurs in this. If allow_overlap
     * is enabled, it allows overlapping of substrings.
     *
     * @param substring Substring to count
     * @param allow_overlap Allow overlaps?
     * @return Number of times substring appears in this
     */
    public int count(String substring, boolean allow_overlap) {
        int c = 0;
        for (int i = 0; i < this.str.length() - substring.length() + 1; i++) {
            /* Substring of the string is equal to the substring
             * we're searching for */
            if (this.str.substring(i, i + substring.length()).equals(substring)) {
                c++;

                /* Increment i to avoid counting overlaps */
                if (!allow_overlap)
                    i += substring.length() - 1;
            }
        }
        return c;
    }
    public int count(SuperString substring, boolean allow_overlap) {
        return this.count(substring.toString(), allow_overlap);
    }

    /**
     * Counts the number of times substring occurs in this. If allow_overlap
     * is enabled, it allows overlapping of substrings. Allow_overlap defaults
     * to false.
     *
     * @param substring Substring to count
     * @return Number of times substring appears in this
     */
    public int count(String substring) {
        return this.count(substring, false);
    }
    public int count(SuperString substring) {
        return this.count(substring.toString(), false);
    }

    /**
     * Converts camel case to dashes. For example,
     * {@code "CamelCase Test".dasherize() -> "camel-case test"}
     *
     * @return Dasherized string
     */
    public String dasherizeString() {
        return this.str.replaceAll("([a-z])([A-Z])", "$1-$2").toLowerCase();
    }

    /**
     * Functionally identical to dasherizeString, but returns a SuperString
     * @return Dasherized String
     */
    public SuperString dasherize() {
        return new SuperString(this.dasherizeString());
    }

    /**
     * Does the string only contain alphabetical characters?
     * @return boolean
     */
    public boolean isAlpha() {
        return this.str.matches("^[a-zA-Z]+$");
    }

    /**
     * Does the string only contain alphanumeric characters?
     * @return boolean
     */
    public boolean isAlphaNumeric() {
        return this.str.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Does the string only contain numeric characters?
     * @return boolean
     */
    public boolean isNumeric() {
        return this.str.matches("^[0-9]+$");
    }

    /**
     * Is the string a valid number?
     * @return boolean
     */
    public boolean isNumber() {
        return this.str.matches("^-?(0|[1-9]\\d*)?(\\.\\d+)?(?<=\\d)$");
    }

    /* I'd like to make a special thanks to
     * luke haas for his collection of regex patterns, which have
     * made the next few methods possible.
     *
     * https://projects.lukehaas.me/regexhub/
     * https://github.com/lukehaas/RegexHub
     */

    /**
     * Does the string match the dd/mm/yyyy date format?
     * @return boolean
     */
    public boolean isDDMMYYYY() {
        return this.str.matches("^(0?[1-9]|[12][0-9]|3[01])([ \\/\\-])(0?[1-9]|1[012])\\2([0-9][0-9][0-9][0-9])(([ -])([0-1]?[0-9]|2[0-3]):[0-5]?[0-9]:[0-5]?[0-9])?$");
    }

    /**
     * Is the string a 24 hour time? Example, 23:12
     * @return boolean
     */
    public boolean is24HourTime() {
        return this.str.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    /**
     * Is the string a valid ISO-8601 date/time? Example:
     * 2018-02-15T23:30:09+00:00 (see https://en.wikipedia.org/wiki/ISO_8601)
     * @return boolean
     */
    public boolean isISO8601Date() {
        return this.str.matches("^(?![+-]?\\d{4,5}-?(?:\\d{2}|W\\d{2})T)(?:|(\\d{4}|[+-]\\d{5})-?(?:|(0\\d|1[0-2])(?:|-?([0-2]\\d|3[0-1]))|([0-2]\\d{2}|3[0-5]\\d|36[0-6])|W([0-4]\\d|5[0-3])(?:|-?([1-7])))(?:(?!\\d)|T(?=\\d)))(?:|([01]\\d|2[0-4])(?:|:?([0-5]\\d)(?:|:?([0-5]\\d)(?:|\\.(\\d{3})))(?:|[zZ]|([+-](?:[01]\\d|2[0-4]))(?:|:?([0-5]\\d)))))$");
    }

    /**
     * Is the string a valid username? Usernames must be alphanumeric
     * and between 3 - 16 characters long.
     * @return boolean
     */
    public boolean isValidUsername() {
        return this.str.matches("^[a-zA-Z0-9_-]{3,16}$");
    }

    /**
     * Is the string a valid hex color code?
     * @return boolean
     */
    public boolean isHexColorCode() {
        return this.str.matches("^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$");
    }

    /**
     * Is the string a valid hex colour code? For you British/Canadians
     * @return boolean
     */
    public boolean isHexColourCode() {
        return this.isHexColorCode();
    }

    /**
     * Is the string a valid email? Very basic matching only, aka
     * {@code <some characters>@<some characters>.<some characters>}
     * @return boolean
     */
    public boolean isValidEmail() {
        return this.str.matches("^.+@.+$");
    }

    /**
     * Is the string a valid url? Some support for ftp and file urls.
     * @return boolean
     */
    public boolean isValidUrl() {
        return this.str.matches("^((https?|ftp|file):\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");
    }

    /**
     * Is the string a valid ipv4 address?
     * @return boolean
     */
    public boolean isValidIpv4() {
        return this.str.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    }

    /**
     * Is the string a valid ipv6 address?
     * @return boolean
     */
    public boolean isValidIpv6() {
        return this.str.matches("^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$");
    }

    /**
     * Basic phone number matching - is the string a valid number?
     * @return boolean
     */
    public boolean isValidPhoneNumber() {
        return this.str.matches("^\\+?(\\d.*){3,}$");
    }

    /**
     * Is the string a valid youtube url?
     * @return boolean
     */
    public boolean isValidYoutubeUrl() {
        return this.str.matches("https?:\\/\\/(?:youtu\\.be\\/|(?:[a-z]{2,3}\\.)?youtube\\.com\\/watch(?:\\?|#\\!)v=)([\\w-]{11}).*");
    }

    /**
     * Is the string morse code?
     * @return boolean
     */
    public boolean isMorseCode() {
        return this.str.matches("^[.-]{1,5}(?:[ \\t]+[.-]{1,5})*(?:[ \\t]+[.-]{1,5}(?:[ \\t]+[.-]{1,5})*)*$");
    }

    /**
     * Is the string a valid postal code? Only matches Canadian and American postal codes.
     * @return boolean
     */
    public boolean isValidPostalCode() {
        return this.str.matches("(^\\d{5}(-\\d{4})?$)|(^[ABCEGHJKLMNPRSTVXY]{1}\\d{1}[A-Z]{1} *\\d{1}[A-Z]{1}\\d{1}$)");
    }


    /**
     * Splits the string along newlines and returns the array.
     * Supports UNIX and Windows newlines
     * @return lines in the text
     */
    public String[] linesString() {
        return this.splitString("\\r?\\n");
    }

    /**
     * Splits the string along newlines and returns the array.
     * Supports UNIX and Windows newlines
     * @return lines in the text
     */
    public SuperString[] lines() {
        return this.split("\\r?\\n");
    }

    /**
     * Pads a string to length, with filler c.
     * Example: {@code "test".pad(6, "-") -> "-test-"}
     *
     * If c has a length greater than 1, the resulting
     * string could have a greater length than the parameter.
     *
     * Furthermore, if the string cannot be evenly padded on
     * both sides, the string will be padded at the beginning first.
     *
     * This method is overridden to allow both String and SuperString
     * as inputs.
     *
     * @param length Length of the target string
     * @param c Filler string, defaults to " "
     * @return Padded string
     */
    public String padString(int length, String c) {
        String returned = this.str;
        int index = 0;
        while (returned.length() < length) {
            /* Pad to start of string first,
             * then to the end */
            returned = index % 2 == 0 ?
                    c + returned : returned + c;
            index++;
        }
        return returned;
    }
    public String padString(int length, SuperString c) {
        return this.padString(length, c.toString());
    }
    public String padString(int length) {
        return this.padString(length, " ");
    }

    /**
     * Functionally identical to padString, but returns SuperString.
     *
     * @param length Length of the target string
     * @param c Filler string, defaults to " "
     * @return Padded string
     */
    public SuperString pad(int length, String c) {
        return new SuperString(this.padString(length, c));
    }
    public SuperString pad(int length, SuperString c) {
        return new SuperString(this.padString(length, c));
    }
    public SuperString pad(int length) {
        return new SuperString(this.padString(length));
    }

    /**
     * Pads a string to the left, to length length, and filler c.
     *
     * If c has a length greater than 1, the resulting
     * string could have a greater length than the parameter.
     *
     * This method is overridden to allow both String and SuperString
     * as inputs.
     *
     * @param length Target length of string
     * @param c Filler string
     * @return Padded string
     */
    public String padLeftString(int length, String c) {
        int repeat_times = Math.max(0, (length - this.length) / c.length());
        return new SuperString(c).repeat(repeat_times).toString() + this.str;
    }
    public String padLeftString(int length, SuperString c) {
        return this.padLeftString(length, c.toString());
    }
    public String padLeftString(int length) {
        return this.padLeftString(length, " ");
    }

    /**
     * Pads a string to the left. Functionally the same as padLeftString, but
     * returns a SuperString instead.
     *
     * @param length Target length of string
     * @param c Filler string
     * @return Padded string
     */
    public SuperString padLeft(int length, String c) {
        return new SuperString(this.padLeftString(length, c));
    }
    public SuperString padLeft(int length, SuperString c) {
        return new SuperString(this.padLeftString(length, c));
    }
    public SuperString padLeft(int length) {
        return new SuperString(this.padLeftString(length));
    }

    /**
     * Pads a string to the right, to length length, and filler c.
     *
     * If c has a length greater than 1, the resulting
     * string could have a greater length than the parameter.
     *
     * This method is overridden to allow both String and SuperString
     * as inputs.
     *
     * @param length Target length of string
     * @param c Filler string
     * @return Padded string
     */
    public String padRightString(int length, String c) {
        int repeat_times = Math.max(0, (length - this.length) / c.length());
        return new SuperString(c).repeat(repeat_times).toString() + this.str;
    }
    public String padRightString(int length, SuperString c) {
        return this.padRightString(length, c.toString());
    }
    public String padRightString(int length) {
        return this.padRightString(length, " ");
    }

    /**
     * Pads a string to the right. Functionally the same as padRightString, but
     * returns a SuperString instead.
     *
     * @param length Target length of string
     * @param c Filler string
     * @return Padded string
     */
    public SuperString padRight(int length, String c) {
        return new SuperString(this.padRightString(length, c));
    }
    public SuperString padRight(int length, SuperString c) {
        return new SuperString(this.padRightString(length, c));
    }
    public SuperString padRight(int length) {
        return new SuperString(this.padRightString(length));
    }

    /**
     * Return self duplicated n times, ie "test".repeat(3) -> "testtesttest"
     * Returns an empty string if n <= 0
     *
     * @param n An integer representing how many times to duplicate the string
     * @return String Duplicated string
     */
    public String repeatString(int n) {
        String r = "";
        for (int i = 0; i < n; i++)
            r += this.str;
        return r;
    }

    /**
     * Duplicate a string n times. Functionally identical to repeatString,
     * except it returns a SuperString instead of a String.
     *
     * @param n An integer representing how many times to duplicate the string
     * @return SuperString Duplicated string
     */
    public SuperString repeat(int n) {
        return new SuperString(this.repeatString(n));
    }

    /**
     * Splits the string from the right, instead of the
     * left as it normally does. DOES NOT SUPPORT REGEX
     *
     * WARNING: Highly unoptimized, creates copies of the array
     * so it's not recommended to use on large arrays.
     *
     * @param s String to split by.
     * @param limit Limit to number of times to split along s
     *              Total array element length = limit + 1
     * @return Splitted string
     */
    public String[] splitFromRightString(String s, int limit) {
        /* Split along s, then reverse the array. */
        String[] result = this.str.split(SuperString.escapeRegexString(s));
        for (int i = 0; i < result.length / 2; i++) {
            String temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }

        /* Create a copy of the array up to limit, then another
         * copy from limit to the end */
        limit = Math.min(result.length, limit);
        String[] final_arr = Arrays.copyOfRange(result, 0, limit);
        result = Arrays.copyOfRange(result, limit, result.length);

        /* There is an end part, so join the end part and add
         * it to the end of the final array */
        if (result.length > 0) {
            String final_ele = String.join(s, result);
            String[] temp = new String[final_arr.length + 1];
            for (int i = 0; i < final_arr.length; i++)
                temp[i] = final_arr[i];
            temp[temp.length - 1] = final_ele;
            return temp;
        }
        return final_arr;
    }
    public String[] splitFromRightString(String s) {
        /* Split along s, then reverse the array. */
        String[] result = this.str.split(SuperString.escapeRegexString(s));
        for (int i = 0; i < result.length / 2; i++) {
            String temp = result[i];
            result[i] = result[result.length - i - 1];
            result[result.length - i - 1] = temp;
        }
        return result;
    }
    public String[] splitFromRightString(SuperString s, int limit) {
        return this.splitFromRightString(s.toString(), limit);
    }
    public String[] splitFromRightString(SuperString s) {
        return this.splitFromRightString(s.toString());
    }

    /**
     * Same as splitFromRightString, but returns SuperString[]
     *
     * @param s String to split by.
     * @param limit Limit to number of times to split along s
     *              Total array element length = limit + 1
     * @return Splitted string
     */
    public SuperString[] splitFromRight(String s, int limit) {
        return SuperString.StringArrToSuperStringArr(this.splitFromRightString(s, limit));
    }
    public SuperString[] splitFromRight(SuperString s, int limit) {
        return SuperString.StringArrToSuperStringArr(this.splitFromRightString(s, limit));
    }
    public SuperString[] splitFromRight(String s) {
        return SuperString.StringArrToSuperStringArr(this.splitFromRightString(s));
    }
    public SuperString[] splitFromRight(SuperString s) {
        return SuperString.StringArrToSuperStringArr(this.splitFromRightString(s));
    }

    /**
     * Chunks the string into chunk_size chunked chunks. For example,
     * {@code "hello world".chunk(2) -> {"he", "ll", "o ", "wo", "rl", "d"}}
     *
     * @param chunk_size Chunk size
     * @return Chunked array
     */
    public String[] chunkString(int chunk_size) {
        int total_chunks = (int) Math.ceil((double) this.length / chunk_size);
        String[] returned = new String[total_chunks];
        for (int i = 0; i < total_chunks; i++) {
            returned[i] = this.str.substring(i * chunk_size,
                    Math.min(this.str.length(), i * chunk_size + chunk_size));
        }
        return returned;
    }

    /**
     * Chunks the string into chunk_size chunked chunks. For example,
     * {@code "hello world".chunk(2) -> {"he", "ll", "o ", "wo", "rl", "d"}}
     *
     * Functionally identical to chunkString, but returns a SuperString[] instead.
     *
     * @param chunk_size Chunk size
     * @return Chunked array
     */
    public SuperString[] chunk(int chunk_size) {
        String[] temp = this.chunkString(chunk_size);
        return SuperString.StringArrToSuperStringArr(temp);
    }

    /**
     * Chunks the string into total_chunks total chunks.
     * For example, {@code "hello world".chunkIntoNString(3) ->
     *  {"hell", "o wo", "rld"}}
     *
     * @param total_chunks Total number of chunks
     * @return chunked string array of length total_chunks
     */
    public String[] chunkIntoNChunksString(int total_chunks) {
        int chunk_size = (int) Math.ceil((double) this.length / total_chunks);
        String[] returned = new String[total_chunks];

        for (int i = 0; i < total_chunks; i++) {
            returned[i] = this.str.substring(i * chunk_size,
                    Math.min(this.str.length(), i * chunk_size + chunk_size));
        }
        return returned;
    }

    /**
     * Chunks the string into total_chunks total chunks.
     * For example, {@code "hello world".chunkIntoNString(3) ->
     *  {"hell", "o wo", "rld"}}
     *
     * Functionally identical to chunkIntoNString, but returns
     * SuperString[] instead.
     *
     * @param total_chunks Total number of chunks
     * @return chunked string array of length total_chunks
     */
    public SuperString[] chunkIntoNChunks(int total_chunks) {
        String[] temp = this.chunkIntoNChunksString(total_chunks);
        return SuperString.StringArrToSuperStringArr(temp);
    }


    /* --- Enhanced functionality --- */
    /**
     * Insert a substring at an index
     * @param index index to insert
     * @param substr substring to insert
     * @return Inserted string
     */
    public String insertString(int index, String substr) {
        return this.substringString(0, index) + substr + this.substringString(index);
    }
    public String insertString(int index, SuperString substr) {
        return this.insertString(index, substr.toString());
    }

    /**
     * Insert a substring at an index. Same as insertString, but
     * returns a SuperString
     *
     * @param index index to insert
     * @param substr substring to insert
     * @return
     */
    public SuperString insert(int index, String substr) {
        return new SuperString(this.insertString(index, substr));
    }
    public SuperString insert(int index, SuperString substr) {
        return new SuperString(this.insertString(index, substr));
    }

    /**
     * Formats the string into a paragraph with each line
     * of length line_length
     *
     * @param line_length Length of each line
     * @param allow_word_break Break between words?
     * @return wrapped string
     */
    public String wrapString(int line_length, boolean allow_word_break) {
        String new_str = "";
        int current_line_length = 0;
        boolean add_newline;

        for (int i = 0; i < this.length; i++) {
            add_newline = false;

            if (current_line_length >= line_length) {
                /* Should the program add a newline? If allowed to break in the middle
                 * of a word then it will default to true, otherwise it will
                 * search for the next space */
                add_newline = allow_word_break || this.str.substring(i, i + 1).equals(" ");
            }
            new_str += add_newline ? "\n" : this.str.substring(i, i + 1);
            current_line_length++;

            /* If we're not breaking on a space, don't skip the current character! */
            if (add_newline && !this.str.substring(i, i + 1).equals(" ")) i--;
            if (add_newline) current_line_length = 0;

        }
        return new_str;
    }

    /**
     * Formats the string into a paragraph with each line
     * of length line_length
     *
     * @param line_length Length of each line
     * @return wrapped string
     */
    public String wrapString(int line_length) {
        return this.wrapString(line_length, true);
    }

    /**
     * Formats the string into a paragraph with each line
     * of length line_length. Returns SuperString
     *
     * @param line_length Length of each line
     * @param allow_word_break Break between words?
     * @return wrapped string
     */
    public SuperString wrap(int line_length, boolean allow_word_break) {
        return new SuperString(this.wrapString(line_length, allow_word_break));
    }
    public SuperString wrap(int line_length) {
        return new SuperString(this.wrapString(line_length));
    }

    /**
     * Rotates a string by offset. Values are rotated going to the left,
     * for example {@code "hello world".rotateString(1) -> "ello worldh"}
     *
     * If a negative offset is passed, it will rotate to the right instead.
     *
     * @param offset Offset to rotate string.
     * @return Rotated string
     */
    public String rotateString(int offset) {
        offset = offset % this.length;
        while (offset < 0) offset += this.length; // Fix for java's % operator returning negative values
        return this.str.substring(offset) + this.str.substring(0, offset);
    }

    /**
     * Same as rotateString, but returns a SuperString instead.
     * @param offset Offset to rotate string.
     * @return Rotated string
     */
    public SuperString rotate(int offset) {
        return new SuperString(this.rotateString(offset));
    }

    /**
     * Shifts a string, caesar cipher style.
     * @param offset Offset to shift
     * @param only_shift_alpha Only shift alphabetical characters, otherwise
     *                         shifts by ASCII character code
     * @return Shifted string
     */
    public String shiftString(int offset, boolean only_shift_alpha) {
        String new_string = "";
        String s = this.str;
        String[] letters;

        /* Do a caesar cipher style shift, converting
         * all letters to uppercase first, then shifting. Non-alpha
         * characters are ignored. */
        if (only_shift_alpha) {
            s = s.toUpperCase();
            letters = s.split("");

            for (String letter: letters) {
                if (SuperString.alphabet_upper.includes(letter)) {
                    int index_of_new_char = alphabet_upper.indexOf(letter) + offset;
                    index_of_new_char %= alphabet_upper.length;

                    // Fix for java's negative mod
                    while (index_of_new_char < 0)
                        index_of_new_char += alphabet_upper.length;
                    new_string += alphabet_upper.getSuperStringAt(index_of_new_char);
                } else {
                    /* Ignore non-alphabetical characters */
                    new_string += letter;
                }
            }
        }

        /* Shift each character using the ASCII code instead */
        else {
            letters = s.split("");
            for (String letter: letters) {
                int index_of_new_char = letter.codePointAt(0) + offset;
                new_string += String.valueOf(Character.toChars(index_of_new_char));
            }
        }
        return new_string;
    }
    public String shiftString(int offset) {
        return this.shiftString(offset, true);
    }

    /**
     * Same as shiftString, but returns SuperString
     * @param offset Offset to shift
     * @param only_shift_alpha Only shift alphabetical characters, otherwise
     *                         shifts by ASCII character code
     * @return Shifted string
     */
    public SuperString shift(int offset, boolean only_shift_alpha) {
        return new SuperString(this.shiftString(offset, only_shift_alpha));
    }
    public SuperString shift(int offset) {
        return new SuperString(this.shiftString(offset));
    }

    /**
     * Deletes the portion of the string from start_index to
     * end_index, and returns the new string.
     *
     * @param start_index Start index to delete
     * @param end_index End index to delete
     * @return New string
     */
    public String deleteString(int start_index, int end_index) {
        return this.substringString(0, start_index) + this.substringString(end_index);
    }

    /**
     * Deletes the character at start_index.
     *
     * @param start_index Start index to delete
     * @return New string
     */
    public String deleteString(int start_index) {
        return this.deleteString(start_index, start_index + 1);
    }

    /**
     * Same as deleteString, but returns SuperString.
     *
     * @param start_index Start index to delete
     * @param end_index End index to delete
     * @return New string
     */
    public SuperString delete(int start_index, int end_index) {
        return new SuperString(this.deleteString(start_index, end_index));
    }
    public SuperString delete(int start_index) {
        return new SuperString(this.deleteString(start_index));
    }

    /**
     * Returns all regex match groups in the string as
     * an ArrayList of Strings
     *
     * @param r Regex to match
     * @return Matched groups
     */
    public ArrayList < String > matchString(String r) {
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(this.str);
        ArrayList < String > returned = new ArrayList < String > ();

        while (matcher.find()) {
            returned.add(matcher.group());
        }
        return returned;
    }
    public ArrayList < String > matchString(SuperString r) {
        return this.matchString(r.toString());
    }

    /**
     * Returns all regex match groups in the string as
     * an ArrayList of SuperStrings
     *
     * @param r Regex to match
     * @return Matched groups
     */
    public ArrayList < SuperString > match(String r) {
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(this.str);
        ArrayList < SuperString > returned = new ArrayList < SuperString > ();

        while (matcher.find()) {
            returned.add(new SuperString(matcher.group()));
        }
        return returned;
    }
    public ArrayList < SuperString > match(SuperString r) {
        return this.match(r.toString());
    }

    /**
     * Does this string occur before parameter s in the alphabet?
     * For example, {@code "apple".isBeforeAlphabetically("book") -> true.}
     * Returns false if this equals s.
     *
     * Overloaded to accept both SuperString and String as input.
     *
     * @param s SuperString or String to compare against
     * @return boolean Is this before s alphabetically?
     */
    public boolean isBeforeAlphabetically(SuperString s) {
        return s.compareToIgnoreCase(s) < 0;
    }
    public boolean isBeforeAlphabetically(String s) {
        return s.compareToIgnoreCase(s) < 0;
    }

    /**
     * Does this string occur after parameter s in the alphabet?
     * For example, {@code "apple".isAfterAlphabetically("book") -> false.}
     * Returns false if this equals s.
     *
     * Overloaded to accept both SuperString and String as input
     *
     * @param s SuperString or String to compare against
     * @return boolean Is this after s alphabetically?
     */
    public boolean isAfterAlphabetically(SuperString s) {
        return s.compareToIgnoreCase(s) > 0;
    }
    public boolean isAfterAlphabetically(String s) {
        return s.compareToIgnoreCase(s) > 0;
    }

    /**
     * Does the string contain a substring s? Overloaded to accept both String and SuperString.
     * @param s String to search for
     * @return boolean Does s appear in this?
     */
    public boolean includes(String s) {
        return this.str.indexOf(s) != -1;
    }
    public boolean includes(SuperString s) {
        return this.str.indexOf(s.toString()) != -1;
    }

    /**
     * Converts the string to an int, using parseInt.
     * Will throw an error if the string is invalid.
     * Also parses the string as a hex value if it starts
     * with 0x or -0x
     *
     * @return integer
     */
    public int toInt() {
        /* This will throw an exception if the string
         * is not a valid integer */
        if (this.str.startsWith("-0x") || this.str.startsWith("0x"))
            return Integer.parseInt(this.str.split("x")[1], 16);
        return Integer.parseInt(this.str);
    }


    /**
     * Converts the string to a double, using parseDouble.
     * Will throw an error if the string is invalid. Does not
     * handle hex values.
     * @return double
     */
    public double toDouble() {
        return Double.parseDouble(this.str);
    }

    /**
     * Converts the string to a float, using parseFloat.
     * Will throw an error if the string is invalid. Does not
     * handle hex values
     * @return float
     */
    public float toFloat() {
        return Float.parseFloat(this.str);
    }

    /**
     * Converts the string to a long, using parseLong.
     * Will throw an error if the string is invalid. Does not
     * handle hex values
     * @return long
     */
    public long toLong() {
        return Long.parseLong(this.str);
    }

    /**
     * Convert the string to a BigDecimal using default
     * BigDecimal constructor. Throws an error is the string
     * is invalid.
     *
     * @return BigDecimal
     */
    public BigDecimal toBigDecimal() {
        return new BigDecimal(this.str);
    }

    /**
     * Converts the string to a boolean. Values like "yes", "true", or
     * "1" return true, other values return false.
     *
     * This method is case insensitive.
     *
     * @return boolean.
     */
    public boolean toBool() {
        if (this.str.toLowerCase().equals("yes"))
            return true;
        if (this.str.toLowerCase().equals("true"))
            return true;
        if (this.str.toLowerCase().equals("y"))
            return true;
        if (this.str.toLowerCase().equals("1"))
            return true;
        return false;
    }

    /**
     * Take a substring starting at start_index of length length. For example,
     * "hello world".substr(1, 4) -> "ello".
     *
     * Mostly functionally identical to javascript's
     * substr, except that it throws an IndexOutOfBoundsException for an invalid
     * start_index (Note that start_index can be negative)
     *
     * @param start_index The index to start at. If it's negative, will count backwards from end of string
     * @param length Length of the substring
     * @exception IndexOutOfBoundsException Thrown when start_index is not in range of 0 to this.length - 1
     * @return String substring that matched
     */
    public String substrString(int start_index, int length) {
        /* If start_index + length > max_index, set the length
         * to the largest possible length that matches. This way,
         * examples such as "test".substr(0, 10000) won't throw an
         * IndexOutOfBoundsException (and thus will not require extra
         * code to make sure the bounds are correct) */
        if (start_index + length > this.length)
            length = this.length - start_index;
        /* If start_index is negative it will try to count backwards */
        if (start_index < 0)
            start_index = this.length + start_index - length + 1;
        return this.substringString(start_index, start_index + length);
    }

    /**
     * Functionally the same as substrString, but returns a SuperString
     * @param start_index The index to start at. If it's negative, will count backwards from end of string
     * @param length Length of the substring
     * @exception IndexOutOfBoundsException Thrown when start_index is not in range of 0 to this.length - 1
     * @return String substring that matched
     */
    public SuperString substr(int start_index, int length) {
        return new SuperString(this.substrString(start_index, length));
    }

    /**
     * Is the string uppercase (aka entirely composed of uppercase characters?)
     * @return boolean isUpperCase
     */
    public boolean isUpper() {
        return this.toUpperCase().equals(this);
    }

    /**
     * Is the string lowercase (aka entirely composed of lowercase characters?)
     * @return boolean isLowerCase
     */
    public boolean isLower() {
        return this.toLowerCase().equals(this);
    }

    /**
     * Returns a new String based on the left n characters. For example,
     * "test".left(2) -> "te"
     *
     * If n is negative, starts counting from the right instead, ie
     * "test".left(-2) -> "st"
     *
     * @param n Number of characters to take
     * @exception IndexOutOfBoundsException Thrown when n > this.length
     * @return String String made of left n characters
     */
    public String leftString(int n) {
        if (n < 0) return this.rightString(-n);
        return this.str.substring(0, n);
    }

    /** Functionally identical to leftString, but returns SuperString
     * @param n Number of characters to take
     * @exception IndexOutOfBoundsException Thrown when n > this.length
     * @return SuperString String made of left n characters
     */
    public SuperString left(int n) {
        return new SuperString(this.leftString(n));
    }

    /**
     * Returns a new String based on the right n characters. For example,
     * "test".right(2) -> "st"
     *
     * If n is negative, starts counting from the left instead, ie
     * "test".right(-2) -> "te"
     *
     * @param n Number of characters to take
     * @exception IndexOutOfBoundsException Thrown when n > this.length
     * @return String String made of right n characters
     */
    public String rightString(int n) {
        if (n < 0) return this.leftString(-n);
        return this.str.substring(this.length - n, this.length);
    }

    /** Functionally identical to rightString, but returns SuperString
     * @param n Number of characters to take
     * @exception IndexOutOfBoundsException Thrown when n > this.length
     * @return SuperString String made of right n characters
     */
    public SuperString right(int n) {
        return new SuperString(this.rightString(n));
    }

    /**
     * Reverses the current string
     * @return Reversed string
     */
    public String reverseString() {
        String new_str = "";
        for (int i = this.length - 1; i >= 0; i--)
            new_str += this.str.substring(i, i + 1);
        return new_str;
    }

    /**
     * Reverses the current string
     * @return Reversed string
     */
    public SuperString reverse() {
        return new SuperString(this.reverseString());
    }

    /**
     * Splice a string, just like javascript array splicing. It takes
     * a portion starting at index with length length, and replaces it
     * with the replacement string. This is overloaded to accept both
     * String and SuperString parameters.
     *
     * If the length + index > string.length(), it will round down to
     * string length.
     *
     * Negative indexes are supported, in which case it will count backwards.
     *
     * @param index
     * @param length
     * @param replacement
     * @return spliced string
     */
    public String spliceString(int index, int length, String replacement) {
        if (index + length > this.length) length = this.length - index;
        if (index < 0) index = this.length + index;
        return this.substring(0, index) + replacement + this.substring(index + length);
    }
    public String spliceString(int index, int length, SuperString replacement) {
        return this.spliceString(index, length, replacement.toString());
    }

    /**
     * Functionally identical to spliceString, but returns SuperString.
     * @param index
     * @param length
     * @param replacement
     * @return spliced string
     */
    public SuperString splice(int index, int length, String replacement) {
        return new SuperString(this.spliceString(index, length, replacement));
    }
    public SuperString splice(int index, int length, SuperString replacement) {
        return new SuperString(this.spliceString(index, length, replacement));
    }

    /**
     * Returns the string, with each arg deleted. Args can either
     * be a char[], String[] or SuperString[]. Varargs are also
     * supported, so you can do .strip("a", "b") instead of .strip({"a", "b"}
     *
     * If args is empty, trims the string instead.
     *
     * @param args Stuff to delete in the string
     * @return Stripped string
     */
    public String stripString(String...args) {
        String new_str = this.str;
        for (String s: args)
            new_str = new_str.replaceAll(s, "");
        return new_str;
    }
    public String stripString(char...args) {
        String new_str = this.str;
        for (char s: args)
            new_str = new_str.replaceAll(String.valueOf(s), "");
        return new_str;
    }
    public String stripString(SuperString...args) {
        String new_str = this.str;
        for (SuperString s: args)
            new_str = new_str.replaceAll(String.valueOf(s), "");
        return new_str;
    }

    /**
     * Functionally the same as stripString, but returns
     * a SuperString instead.
     *
     * @param args
     * @return Stripped string
     */
    public SuperString strip(String...args) {
        return new SuperString(this.stripString(args));
    }
    public SuperString strip(char...args) {
        return new SuperString(this.stripString(args));
    }
    public SuperString strip(SuperString...args) {
        return new SuperString(this.stripString(args));
    }

    /**
     * Returns the string, with each arg deleted, but only if the
     * argument appears at the beginning of the string. Args can either
     * be a char[], String[] or SuperString[]. Varargs are also
     * supported, so you can do .strip("a", "b") instead of .strip({"a", "b"}
     *
     * If args is empty, left trims the string instead.
     *
     * @param args Stuff to delete in the string
     * @return Stripped string
     */
    public String stripLeftString(String...args) {
        String new_str = this.str;
        for (String s: args) {
            if (new_str.startsWith(String.valueOf(s)))
                new_str = new_str.replaceFirst(s, "");
        }
        return new_str;
    }
    public String stripLeftString(char...args) {
        String new_str = this.str;
        for (char s: args) {
            if (new_str.startsWith(String.valueOf(s)))
                new_str = new_str.replaceFirst(String.valueOf(s), "");
        }
        return new_str;
    }
    public String stripLeftString(SuperString...args) {
        String new_str = this.str;
        for (SuperString s: args) {
            if (new_str.startsWith(String.valueOf(s)))
                new_str = new_str.replaceFirst(String.valueOf(s), "");
        }
        return new_str;
    }
    public String stripLeftString() {
        return this.trimLeftString();
    }

    /**
     * Functionally the same as stripLeftString, but returns
     * a SuperString instead.
     *
     * @param args
     * @return Stripped string
     */
    public SuperString stripLeft(String...args) {
        return new SuperString(this.stripLeftString(args));
    }
    public SuperString stripLeft(char...args) {
        return new SuperString(this.stripLeftString(args));
    }
    public SuperString stripLeft(SuperString...args) {
        return new SuperString(this.stripLeftString(args));
    }
    public SuperString stripLeft() {
        return this.trimLeft();
    }

    /**
     * Returns the string, with each arg deleted, but only if the
     * argument appears at the end of the string. Args can either
     * be a char[], String[] or SuperString[]. Varargs are also
     * supported, so you can do .strip("a", "b") instead of .strip({"a", "b"}
     *
     * If args is empty, right trims the string instead.
     *
     * @param args Stuff to delete in the string
     * @return Stripped string
     */
    public String stripRightString(String...args) {
        String new_str = this.str;
        for (String s: args) {
            if (new_str.endsWith(String.valueOf(s)))
                new_str = new_str.replaceAll(SuperString.escapeRegexString(s) + "$", "");
        }
        return new_str;
    }
    public String stripRightString(char...args) {
        String new_str = this.str;
        for (char s: args) {
            if (new_str.endsWith(String.valueOf(s)))
                new_str = new_str.replaceAll(SuperString.escapeRegexString(String.valueOf(s)) + "$", "");
        }
        return new_str;
    }
    public String stripRightString(SuperString...args) {
        String new_str = this.str;
        for (SuperString s: args) {
            if (new_str.endsWith(String.valueOf(s)))
                new_str = new_str.replaceAll(SuperString.escapeRegexString(String.valueOf(s)) + "$", "");
        }
        return new_str;
    }
    public String stripRightString() {
        return this.trimRightString();
    }

    /**
     * Functionally the same as stripRightString, but returns
     * a SuperString instead.
     *
     * @param args
     * @return Stripped string
     */
    public SuperString stripRight(String...args) {
        return new SuperString(this.stripRightString(args));
    }
    public SuperString stripRight(char...args) {
        return new SuperString(this.stripRightString(args));
    }
    public SuperString stripRight(SuperString...args) {
        return new SuperString(this.stripRightString(args));
    }
    public SuperString stripRight() {
        return this.trimRight();
    }

    /**
     * Removes all punctuation from the string.
     * @return Stripped string
     */
    public String stripPunctuationString() {
        return this.str.replaceAll("[\\.,-\\/#!$%\\^&\\*;:{}=\\-_`~()]", "");
    }

    /**
     * Same as stripPunctuationString, but returns a
     * SuperString object.
     * @return Stripped string
     */
    public SuperString stripPunctuation() {
        return new SuperString(this.stripPunctuationString());
    }

    /**
     * Does the string only contain characters in
     * the charset?
     * @param charset Characters to check
     * @return Boolean
     */
    public boolean containsOnly(char[] charset) {
        for (int i = 0; i < this.str.length(); i++) {
            char c = this.str.charAt(i);
            for (int j = 0; j < charset.length; j++) {
                if (charset[j] == c)
                    continue;
            }
            return false;
        }
        return true;
    }

    /**
     * Does the string not contain any characters in
     * the charset?
     * @param charset Characters to check
     * @return Boolean
     */
    public boolean containsNone(char[] charset) {
        return !this.containsOnly(charset);
    }

    /* --- Standard class functionality --- */
    public String toString() {
        return this.str;
    }
    public boolean equals(SuperString other) {
        return this.str.equals(other.toString());
    }
    public boolean equals(String other) {
        return this.str.equals(other);
    }
    public boolean equalsIgnoreCase(SuperString other) {
        return this.str.equalsIgnoreCase(other.toString());
    }
    public boolean equalsIgnoreCase(String other) {
        return this.str.equalsIgnoreCase(other);
    }

    /* Returns memory location of SuperString, as the non
     * overridden toString would return (classname@hashCode) */
    public String getHashCode() {
        return "SuperString@" + Integer.toHexString(this.hashCode());
    }

    /* Iterator, so you can iterate over a SuperString like
     * for(SuperString i: string) */
    public Iterator < SuperString > iterator() {
        return Arrays.asList(this.toSuperStringArray()).iterator();
    }

    /* Cloning support. Does not implement Cloneable, rather
     * simply acts as a copy constructor */
    public SuperString clone() {
        return new SuperString(this.str);
    }


    /* --- Static methods --- */
    public static String copyValueOfString(char[] data) {
        return String.copyValueOf(data);
    }
    public static String copyValueOfString(char[] data, int offset, int count) {
        return String.copyValueOf(data, offset, count);
    }
    public static SuperString copyValueOf(char[] data) {
        return new SuperString(SuperString.copyValueOfString(data));
    }
    public static SuperString copyValueOf(char[] data, int offset, int count) {
        return new SuperString(SuperString.copyValueOfString(data, offset, count));
    }

    public static String formatString(Locale l, String format, Object...args) {
        return String.format(l, format, args);
    }
    public static String formatString(String format, Object...args) {
        return String.format(format, args);
    }
    public static SuperString format(Locale l, String format, Object...args) {
        return new SuperString(String.format(l, format, args));
    }
    public static SuperString format(String format, Object...args) {
        return new SuperString(String.format(format, args));
    }

    public static String valueOfString(boolean x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(boolean x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(byte x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(byte x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(char x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(char x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(short x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(short x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(int x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(int x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(long x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(long x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(float x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(float x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(double x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(double x) {
        return new SuperString(String.valueOf(x));
    }
    public static String valueOfString(Object x) {
        return String.valueOf(x);
    }
    public static SuperString valueOf(Object x) {
        return new SuperString(String.valueOf(x));
    }


    public static String escapeRegexString(String re) {
        return re.replaceAll("[-\\[\\]{}()*+?.,\\\\\\\\^$|#\\\\s]", "\\\\$0");
    }
    public static String escapeRegexString(SuperString re) {
        return SuperString.escapeRegexString(re.toString());
    }
    public static SuperString escapeRegex(String re) {
        return new SuperString(SuperString.escapeRegexString(re));
    }
    public static SuperString escapeRegex(SuperString re) {
        return new SuperString(SuperString.escapeRegexString(re));
    }

    public static SuperString[] StringArrToSuperStringArr(String[] arr) {
        SuperString[] returned = new SuperString[arr.length];
        for (int i = 0; i < arr.length; i++)
            returned[i] = new SuperString(arr[i]);
        return returned;
    }

    public static String[] SuperStringArrToStringArr(SuperString[] arr) {
        String[] returned = new String[arr.length];
        for (int i = 0; i < arr.length; i++)
            returned[i] = arr[i].toString();
        return returned;
    }

    /**
     * Converts a String[] or SuperString[] to a sentence.
     * For example, {@code toSentenceString("a","b","c") -> "a, b, and c"}
     * @param arr Array
     * @return Sentence
     */
    public static String toSentenceString(String...arr) {
        if (arr.length == 0)
            return "";

        String returned = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                returned += ", and " + arr[i];
            else
                returned += ", " + arr[i];
        }
        return returned;
    }
    public static String toSentenceString(SuperString...arr) {
        return SuperString.toSentenceString(SuperString.SuperStringArrToStringArr(arr));
    }
    public static SuperString toSentence(String...arr) {
        return new SuperString(SuperString.toSentenceString(arr));
    }
    public static SuperString toSentence(SuperString...arr) {
        return new SuperString(SuperString.toSentenceString(arr));
    }
}
