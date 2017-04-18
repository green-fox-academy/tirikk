class Reptile extends Animal {

  Reptile(String name) {
    super(name);
  }

  String wantChild() {
    return "wants a child from an egg!";
  }
}
