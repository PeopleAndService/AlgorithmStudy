class HashTable:
    def __init__(self, table_size):
        self.table_size = table_size
        self.hash_table = [0 for _ in range(self.table_size)]

    def getKey(self, data):
        return ord(data[0])

    def hashFunction(self, key):
        return key % self.table_size

    def getAddress(self, key):
        hash_key = key if type(key) is int else self.getKey(key)
        hash_address = self.hashFunction(hash_key)
        return hash_address

    def put(self, key, value):
        hash_address = self.getAddress(key)
        self.hash_table[hash_address] = value

    def get(self, key):
        hash_address = self.getAddress(key)
        return self.hash_table[hash_address]

    def delete(self, key):
        hash_address = self.getAddress(key)
        if self.hash_table[hash_address] != 0:
            self.hash_table[hash_address] = 0
            return True
        else: return False

class OpenHashTable:
    def __init__(self, table_size):
        self.table_size = table_size
        self.hash_table = [[] for _ in range(self.table_size)]

    def getKey(self, data):
        return ord(data[0])

    def hashFunction(self, key):
        return key % self.table_size

    def getAddress(self, key):
        hash_key = key if type(key) is int else self.getKey(key)
        hash_address = self.hashFunction(hash_key)
        return hash_address

    def put(self, key, value):
        hash_address = self.getAddress(key)

        if self.hash_table[hash_address]:
            for chaining_index in range(len(self.hash_table[hash_address])):
                if self.hash_table[hash_address][chaining_index][0] == key:
                    self.hash_table[hash_address][chaining_index][1] = value
                    return
            self.hash_table[hash_address].append([key, value])
        else:
            self.hash_table[hash_address] = [[key, value]]

    def get(self, key):
        hash_address = self.getAddress(key)

        if self.hash_table[hash_address]:
            for chaining_index in range(len(self.hash_table[hash_address])):
                if self.hash_table[hash_address][chaining_index][0] == key:
                    return self.hash_table[hash_address][chaining_index][0]
            return False
        else:
            return False

    def delete(self, key):
        hash_address = self.getAddress(key)

        if self.hash_table[hash_address]:
            for chaining_index in range(len(self.hash_table[hash_address])):
                if self.hash_table[hash_address][chaining_index][0] == key:
                    if len(self.hash_table[hash_address]) == 1:
                        self.hash_table[hash_address] = []
                    else:
                        del self.hash_table[hash_address][chaining_index]
                    return
            return False
        else:
            return False

class CloseHashTable:
    def __init__(self, table_size, parameter):
        self.table_size = table_size
        self.function_parameter = parameter
        self.hash_table = [[] for _ in range(self.table_size)]

    def getKey(self, data):
        return ord(data[0])

    def hashFunction(self, key):
        return key % self.table_size

    def hashFunction2(self, key):
        return 1 + key % self.function_parameter

    def getAddress(self, key):
        hash_key = key if type(key) is int else self.getKey(key)
        hash_address = self.hashFunction(hash_key)
        return hash_address

    def put(self, key, value):
        hash_address = self.getAddress(key)
        function2_return = self.hashFunction2(key)
        while self.hash_table[hash_address] and self.hash_table[hash_address][0] != "delete":
            hash_address = self.hashFunction(hash_address+function2_return)
        print(key, hash_address)
        self.hash_table[hash_address] = [key, value]

    def get(self, key):
        hash_address = self.getAddress(key)
        function2_return = self.hashFunction2(key)
        while self.hash_table[hash_address]:
            if self.hash_table[hash_address][0] == key: return self.hash_table[hash_address][1]
            hash_address = self.hashFunction(hash_address + function2_return)
        return False

    def delete(self, key):
        hash_address = self.getAddress(key)
        function2_return = self.hashFunction2(key)
        while self.hash_table[hash_address]:
            if self.hash_table[hash_address][0] == key: self.hash_table[hash_address] = ["delete", "delete"]
            hash_address = self.hashFunction(hash_address + function2_return)
        return False


h_table = CloseHashTable(13, 11)
h_table.put(15, '15')
h_table.put(28, '28')
h_table.put(41, '41')
h_table.put(67, '67')
h_table.put(19, '19')

print(h_table.hash_table)
print(h_table.get(19))

h_table.delete(67)
h_table.put(67, '67')
print(h_table.hash_table)