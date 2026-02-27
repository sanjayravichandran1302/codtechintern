import java.util.*;

public class RecommendationSystem {

    static Map<Integer, Map<String, Integer>> userRatings = new HashMap<>();

    public static void main(String[] args) {

        addRating(1, "Laptop", 5);
        addRating(1, "Mobile", 4);
        addRating(1, "Tablet", 2);

        addRating(2, "Laptop", 5);
        addRating(2, "Mobile", 5);
        addRating(2, "Headphones", 4);

        addRating(3, "Laptop", 2);
        addRating(3, "Tablet", 5);
        addRating(3, "Headphones", 5);

        recommendProduct(1);
    }

    static void addRating(int userId, String product, int rating) {
        userRatings.putIfAbsent(userId, new HashMap<>());
        userRatings.get(userId).put(product, rating);
    }

    static void recommendProduct(int targetUser) {

        Map<String, Integer> targetRatings = userRatings.get(targetUser);
        int mostSimilarUser = -1;
        int highestSimilarity = -1;

        for (int userId : userRatings.keySet()) {

            if (userId == targetUser)
                continue;

            int similarity = 0;

            for (String product : targetRatings.keySet()) {
                if (userRatings.get(userId).containsKey(product)) {
                    similarity++;
                }
            }

            if (similarity > highestSimilarity) {
                highestSimilarity = similarity;
                mostSimilarUser = userId;
            }
        }

        System.out.println("Most Similar User to User " + targetUser + " is User " + mostSimilarUser);

        System.out.println("Recommended Products:");

        for (String product : userRatings.get(mostSimilarUser).keySet()) {
            if (!targetRatings.containsKey(product)) {
                System.out.println(product);
            }
        }
    }
}