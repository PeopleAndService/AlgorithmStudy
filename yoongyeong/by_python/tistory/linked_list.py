class Node:
    def __init__(self, data):
        self.data = data
        self.prev_node = None
        self.next_node = None

    def __str__(self):
        return str(self.data)

class SingleLinkedList:
    def __init__(self, data):
        new_node = Node(data)
        self.head = new_node
        self.list_size = 1

    def __str__(self):
        print_list = '[ '
        node = self.head
        while True:
            print_list += str(node)
            if node.next_node is None:
                break
            node = node.next_node
            print_list += ', '
        print_list += ' ]'
        return print_list

    def select_node(self, num):
        if self.list_size < num: return
        node = self.head
        count = 0
        while count < num - 1:
            node = node.next_node
            count += 1
        return node

    def insert_head(self, data):
        new_node = Node(data)
        new_node.next_node = self.head if self.head is not None else None
        self.head = new_node
        self.list_size += 1

    def insert_tail(self, data):
        node = self.head
        while True:
            if node.next_node is None: break
            node = node.next_node

        new_node = Node(data)
        node.next_node = new_node
        self.list_size += 1

    def insert_node(self, num, data):
        if self.head.next_node is None or num == -1: self.insert_tail(data); return
        if self.head is None or num == 0: self.insert_head(data); return
        node = self.select_node(num)
        new_node = Node(data)
        node.next_node, new_node.next_node = new_node, node.next_node
        self.list_size += 1

    def delete_head(self):
        node = self.head
        self.head = node.next_node
        del node
        self.list_size -= 1

    def delete_tail(self):
        node = self.select_node(self.list_size - 1)
        node.next_node, del_node = None, node.next_node
        del del_node
        self.list_size -= 1

    def delete_node(self, num):
        if self.list_size < 1 or self.list_size < num: return
        if num == 0: self.delete_head(); return
        if num == self.list_size: self.delete_tail(); return
        node = self.select_node(num - 1)
        node.next_node, del_node = node.next_node.next_node, node.next_node
        del del_node
        self.list_size -= 1


class DualLinkedList:
    def __init__(self, data):
        new_node = Node(data)
        self.head = new_node
        self.list_size = 1

    def __str__(self):
        print_list = '[ '
        node = self.head
        while True:
            print_list += str(node)
            if node.next_node is None:
                break
            node = node.next_node
            print_list += ', '
        print_list += ' ]'
        return print_list

    def select_node(self, num):
        if self.list_size < num: return
        node = self.head
        count = 0
        while count < num - 1:
            node = node.next_node
            count += 1
        return node

    def insert_head(self, data):
        new_node = Node(data)
        if self.head is not None:
            self.head.prev_node, new_node.next_node = new_node, self.head
        self.head = new_node
        self.list_size += 1

    def insert_tail(self, data):
        node = self.head
        while True:
            if node.next_node is None: break
            node = node.next_node

        new_node = Node(data)
        new_node.prev_node = node
        node.next_node = new_node
        self.list_size += 1

    def insert_node(self, num, data):
        if self.head.next_node is None or num == -1: self.insert_tail(data); return
        if self.head is None or num == 0: self.insert_head(data); return
        node = self.select_node(num)
        new_node = Node(data)
        new_node.prev_node, node.next_node.prev_node = node, new_node
        node.next_node, new_node.next_node = new_node, node.next_node
        self.list_size += 1

    def delete_head(self):
        node = self.head
        self.head = node.next_node
        self.head.prev_node = None
        del node
        self.list_size -= 1

    def delete_tail(self):
        node = self.select_node(self.list_size - 1)
        node.next_node, del_node = None, node.next_node
        del del_node
        self.list_size -= 1

    def delete_node(self, num):
        if self.list_size < 1 or self.list_size < num: return
        if num == 0: self.delete_head(); return
        if num == self.list_size: self.delete_tail(); return
        node = self.select_node(num - 1)
        node.next_node, del_node = node.next_node.next_node, node.next_node
        node.next_node.prev_node = node
        del del_node
        self.list_size -= 1


linked_list = DualLinkedList(1)
linked_list.insert_node(-1, 5)
linked_list.insert_node(-1, 6)
print(linked_list)
linked_list.insert_node(1, 15)
linked_list.insert_node(0, 100)
print(linked_list)
linked_list.delete_node(1)
print(linked_list)
linked_list.delete_node(4)
print(linked_list)