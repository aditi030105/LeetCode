class Solution {
    // Custom Pair class to replace AbstractMap.SimpleEntry
    static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    static class Node {
        String val;
        String subFolder;
        Map<String, Node> children;

        Node(String val) {
            this.val = val;
            this.subFolder = "";
            this.children = new HashMap<>();
        }
    }

    private Node getNode(String val) {
        return new Node(val);
    }

    private void insert(Node root, List<String> path) {
        for (String folder : path) {
            root.children.putIfAbsent(folder, getNode(folder));
            root = root.children.get(folder);
        }
    }

    private String populateNodes(Node root, Map<String, Integer> subFolderMap) {
        List<Pair> subFolderPaths = new ArrayList<>();

        for (Map.Entry<String, Node> entry : root.children.entrySet()) {
            String subFolderResult = populateNodes(entry.getValue(), subFolderMap);
            subFolderPaths.add(new Pair(entry.getKey(), subFolderResult));
        }

        subFolderPaths.sort(Comparator.comparing(pair -> pair.key));

        StringBuilder completePath = new StringBuilder();
        for (Pair pair : subFolderPaths) {
            completePath.append("(").append(pair.key).append(pair.value).append(")");
        }

        root.subFolder = completePath.toString();

        if (!completePath.toString().isEmpty()) {
            subFolderMap.put(completePath.toString(), subFolderMap.getOrDefault(completePath.toString(), 0) + 1);
        }

        return completePath.toString();
    }

    private void removeDuplicates(Node root, Map<String, Integer> subFolderMap) {
        Iterator<Map.Entry<String, Node>> it = root.children.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Node> entry = it.next();
            Node child = entry.getValue();

            if (!child.subFolder.isEmpty() && subFolderMap.get(child.subFolder) > 1) {
                it.remove();
            } else {
                removeDuplicates(child, subFolderMap);
            }
        }
    }

    private void construstResult(Node root, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, Node> entry : root.children.entrySet()) {
            path.add(entry.getKey());
            result.add(new ArrayList<>(path));
            construstResult(entry.getValue(), path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = getNode("/");

        // Construct trie
        for (List<String> path : paths) {
            insert(root, path);
        }

        Map<String, Integer> subFolderMap = new HashMap<>();
        populateNodes(root, subFolderMap);

        removeDuplicates(root, subFolderMap);

        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        construstResult(root, path, result);

        return result;
    }
}