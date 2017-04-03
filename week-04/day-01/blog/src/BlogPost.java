public class BlogPost {
  String authorName;
  String title;
  String text;
  String publicationDate;

  public BlogPost(String author, String cim, String szoveg, String publication) {
    authorName = author;
    title = cim;
    text = szoveg;
    publicationDate = publication;
  }

  public void print() {
    System.out.println(this.text);
  }
}