package web;
import java.io.IOException;
@WebServlet("/listeProduits")
public class FirstServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public FirstServlet() {
    super(); }
    IGestion gestion;
    @Override
    public void init() throws ServletException {
    // TODO Auto-generated method stub
    gestion=new GestionProduitImp();
    }
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Produit> liste=gestion.getAllProducts();
    PrintWriter out=response.getWriter();
    out.print("<html>");
    out.print("<body>");
    out.print("<table border=1>");
    for (Produit p:liste) {
    out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"</td><td>"+p.getQuantite()+"</td></tr>");}
    out.print("</table>");
    out.print("</body>");
    out.print("</html>");
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet (request, response);
    }
}


