class Reptile extends Animal {

  Reptile(String name) {
    setName(name);
  }

  String wantChild() {
    return "wants a child from an egg!";
  }
}
