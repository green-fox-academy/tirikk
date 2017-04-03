import java.util.ArrayList;

public class Blog {
  ArrayList<BlogPost> list = new ArrayList<>();

  public void add(BlogPost blogPost) {
    list.add(blogPost);
  }

  public void delete(int i) {
    list.remove(i);
  }

  public void update(int i, BlogPost blogPost) {
    list.set(i, blogPost);
  }
}

