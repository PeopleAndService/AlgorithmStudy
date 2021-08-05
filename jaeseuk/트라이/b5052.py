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
            if cur_node.data is not None:
                return False

            cur_node = cur_node.children[char]

        return True


for _ in range(int(stdin.readline().rstrip())):
    trie = Trie()
    strings = []
    result = True

    for _ in range(int(stdin.readline().rstrip())):
        string = stdin.readline().rstrip()
        trie.insert(string)
        strings.append(string)

    for string in strings:
        if not trie.search(string):
            result = False
            break

    if result:
        print('YES')
    else:
        print('NO')
