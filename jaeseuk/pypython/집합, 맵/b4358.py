trees = {}

while True:
    try:
        tree = input()

        if tree in trees:
            trees[tree] += 1
        else:
            trees[tree] = 1
    except EOFError:
        break

size = sum(trees.values())
for tree in sorted(trees.keys()):
    print(tree, "%.4f" % (trees[tree] / size * 100))
