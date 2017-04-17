class Bird extends Animal {

  Bird(String name) {
    setName(name);
  }

  String wantChild() {
    return "wants a child from an egg!";
  }
}
