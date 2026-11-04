
   class MyRegex {
     // Regex breakdown:
    // (?:[01]?\d?\d|2[0-4]\d|25[0-5]) matches numbers from 0 to 255 with up to 2 leading zeros
    // {3} ensures the block and a dot repeat exactly 3 times
    // The final block matches the last number without a trailing dot
    String pattern = "^(?:(?:[01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}(?:[01]?\\d?\\d|2[0-4]\\d|25[0-5])$";
}
