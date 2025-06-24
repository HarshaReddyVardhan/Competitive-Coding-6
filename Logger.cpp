// Approach:
// Use a hash map (unordered_map<string, int>) to store the last printed timestamp for each unique message.
// When shouldPrintMessage() is called:
// If the message was printed in the last 10 seconds, return false.
// Otherwise, update the timestamp and return true.

// Time Complexity:
// O(1) average time per call (hash map lookup and update are constant time).

// Space Complexity:
// O(m), where m is the number of unique messages stored in the map.

class Logger {
public:
    unordered_map<string, int> lastTime;
    bool shouldPrintMessage(int timestamp, string message) {
        if (lastTime.count(message) and timestamp - lastTime[message] < 10)
            return false;
        lastTime[message] = timestamp;
        return true;
    }
};
