from sys import stdin


class Node:
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = {}


class Trie:
    def __init__(self):
        self.root = Node(None)

    def insert(self, string):
        cur_node = self.root

        for char in string:
            if char not in cur_node.children:
                cur_node.children[char] = Node(char)

            cur_node = cur_node.children[char]

        cur_node.data = string

    def search(self, string):
        cur_node = self.root

        for char in string:
            if char in cur_node.children:
                cur_node = cur_node.children[char]
            else:
                return False

        if cur_node.data is not None:
            return True


n, m = map(int, stdin.readline().rstrip().split())
trie = Trie()

for _ in range(n):
    trie.insert(stdin.readline().rstrip())

cnt = 0

for _ in range(m):
    if trie.search(stdin.readline().rstrip()):
        cnt += 1

print(cnt)
