package com.multi.algo.day08.c_dfs_bfs;


import java.util.*;

public class A_DFSBFS {

    //dfs - 노드 타고 내려 갔다가 더이상  갈수 없으면 다시 한칸 위로 올라감 다시 내려감.  -> 스택
    //bfs - 너비 레벨 중심. 한단계 아래 레벨 갔다가 그다음 레벨 탐색  -> 큐

    static ArrayList<Integer>[] arr;
    static boolean visited[];

    public static void main(String[] args) {
        //사용자가 본 장르 -> 관련 장르 -> 관련 장르의 하위 장르

        String baseGenre = "액션";
        List<String> recommendedGenres = dfsGenres(baseGenre);
        List<String> recommendedGenresbfs = bfsGenres(baseGenre);

        System.out.println("추천 장르 후보: " + recommendedGenres);
        System.out.println("추천 장르 후보 bfs: " + recommendedGenresbfs);

    }

    private static List<String> bfsGenres(String start) {
        Map<String, List<String>> graph = genreGraph();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);
            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;

    }

    private static List<String> dfsGenres(String start) {
        Map<String, List<String>> graph = genreGraph(); // 장르 연결 그래프
        Set<String> visited = new HashSet<>();          // 중복 방지
        List<String> result = new ArrayList<>();        // 결과 저장
        int maxDepth = 1;                               // 최대 깊이 제한
        dfs(start, graph, visited, result, 0, maxDepth);
        return result;
    }

    private static void dfs(String current, Map<String, List<String>> graph, Set<String> visited, List<String> result, int depth, int maxDepth) {

        if (visited.contains(current) || depth > maxDepth) return;
        visited.add(current);
        result.add(current);
        for (String next : graph.getOrDefault(current, new ArrayList<>())) {
            dfs(next, graph, visited, result, depth + 1, maxDepth);
        }
    }

    private static Map<String, List<String>> genreGraph() {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("액션", List.of("모험", "SF", "드라마"));
        graph.put("모험", List.of("판타지", "스릴러"));
        graph.put("판타지", List.of("애니메이션"));
        graph.put("SF", List.of("미스터리"));
        graph.put("드라마", List.of("멜로/로맨스", "가족"));
        graph.put("멜로/로맨스", List.of("코미디", "음악"));
        graph.put("가족", List.of("애니메이션", "코미디"));
        graph.put("코미디", List.of("음악"));
        graph.put("스릴러", List.of("공포"));
        graph.put("공포", List.of("미스터리"));
        graph.put("음악", List.of("다큐멘터리"));
        return graph;
    }
}
