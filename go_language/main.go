package main

import (
	"fmt"
	"time"
)

type Node struct {
	key   int64
	value int64
	next  *Node
	prev  *Node
}

type DoublyLinkedList struct {
	head     *Node
	tail     *Node
	capacity int64
}

type Hash map[int64]*Node

type Cache struct {
	doublyLinkedList DoublyLinkedList
	hash             Hash
}

func newCache(capacity int64) Cache {
	return Cache{doublyLinkedList: newDoublyLinkedList(capacity), hash: Hash{}}
}

func newDoublyLinkedList(capacity int64) DoublyLinkedList {
	head := &Node{}
	tail := &Node{}

	head.next = tail
	tail.prev = head

	return DoublyLinkedList{head: head, tail: tail, capacity: capacity}
}

type testData struct {
	key   int64
	value int64
}

func (c *Cache) deleteNode(node *Node) {
	nextNode := node.next
	prevNode := node.prev

	nextNode.prev = prevNode
	prevNode.next = nextNode

}

func (c *Cache) addAfterHead(node *Node) {
	nextNode := c.doublyLinkedList.head.next
	c.doublyLinkedList.head.next = node
	node.prev = c.doublyLinkedList.head

	node.next = nextNode
	nextNode.prev = node
}

func (c *Cache) put(key int64, value int64) {
	node, ok := c.hash[key]

	if ok {
		node.value = value
		c.deleteNode(node)
		c.addAfterHead(node)
		return
	}

	if len(c.hash) >= int(c.doublyLinkedList.capacity) {
		tailNode := c.doublyLinkedList.tail.prev
		c.deleteNode(tailNode)
		delete(c.hash, tailNode.key)
	}

	newNode := &Node{key: key, value: value}
	c.hash[key] = newNode
	c.addAfterHead(newNode)

}

func (c *Cache) get(key int64) int64 {
	node, exists := c.hash[key]
	if exists {
		c.deleteNode(node)
		c.addAfterHead(node)
		return node.value
	}
	return -1
}

func main() {
	fmt.Println("Welcome to LRU cache in go-lang")
	cache := newCache(10)

	// Measure time for put operation
	putIterations := 1000000 // Number of iterations for put
	startPut := time.Now()
	for i := 0; i < putIterations; i++ {
		cache.put(int64(i), int64(i*10))
	}
	elapsedPut := time.Since(startPut).Nanoseconds() // Total time for put operations
	fmt.Printf("Total time taken for put operations: %d nanoseconds\n", elapsedPut)

	// Measure time for get operation
	getIterations := 1000000 // Number of iterations for get
	startGet := time.Now()
	for i := 0; i < getIterations; i++ {
		cache.get(int64(i % 10)) // Access keys in a loop
	}
	elapsedGet := time.Since(startGet).Nanoseconds() // Total time for get operations
	fmt.Printf("Total time taken for get operations: %d nanoseconds\n", elapsedGet)
}
