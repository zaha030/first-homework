import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
	private Label name = new Label("姓名:");
	private Label he = new Label("身高:");
	private Label we = new Label("體重:");
	private Label wl = new Label("腰圍:");
	private Label sex = new Label("性別:");
	private Button btn1 = new Button("計算");
	private Button btn2 = new Button("結束");
	private TextField name1 = new TextField();
	private TextField he1 = new TextField();
	private TextField we1 = new TextField();
	private TextField wl1 = new TextField();
	private TextField sex1 = new TextField();
	private Checkbox boy = new Checkbox("男");
	private Checkbox gril = new Checkbox("女");
	private TextArea ta= new TextArea();

	public MainFrame() {
		initComp();
	}

	private void initComp() {
		CheckboxGroup gp = new CheckboxGroup();
		Checkbox boy = new Checkbox("男",gp,true);
		Checkbox gril = new Checkbox("女",gp,true);
		this.setLayout(null);
		this.setBounds(200,200,500,500);
		this.setBackground(Color.LIGHT_GRAY);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		name.setBounds(20, 50, 40, 25);
		name1.setBounds(70,50,120,20);
		he.setBounds(20, 75, 40, 25);
		he1.setBounds(70,75,120,20);
		we.setBounds(20, 100, 40, 25);
		we1.setBounds(70,100,120,20);
		sex.setBounds(200, 50, 40, 25);
		boy.setBounds(260, 50, 30, 25);
		gril.setBounds(300, 50, 30, 25);
		wl.setBounds(200, 75, 40, 25);
		wl1.setBounds(240, 75, 120, 20);
		btn1.setBounds(380, 75, 100, 25);
		btn2.setBounds(380, 100, 100, 25);
		ta.setBounds(20, 135, 450, 340);
		ta.append("BMI公式:\n"+"體重(公斤)/身高(公尺)^2");
		this.add(name);
		this.add(name1);
		this.add(he);
		this.add(he1);
		this.add(we);
		this.add(we1);
		this.add(sex);
		this.add(wl);
		this.add(wl1);
		this.add(boy);
		this.add(gril);
		this.add(btn1);
		this.add(btn2);
		this.add(ta);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent m){
				String s1=name1.getText();
				String s2=he1.getText();
				String s3=we1.getText();
				String s4=wl1.getText();
				float d1=Integer.parseInt(s3);
				double d2=Integer.parseInt(s2);
				d2 /= 100;
				d2 = Math.pow(d2, 2);
				double result = d1/d2;
				boolean b=boy.getState();
				boolean g=gril.getState();
			    ta.append(s1+", 你好\n");
				ta.append("BMI = "+result+", ");
				if(result <18.5){
					ta.append("你屬於體重過輕!!");
				}else if(result >=18.5 && result<24){
					ta.append("你屬於健康體位!!");
				}else if(result >=24 && result <27){
					ta.append("你過重了喔!!");
				}else if(result >=27 && result <30){
					ta.append("你屬於輕度肥胖!!");
				}else if(result >=30 && result <35){
					ta.append("你屬於中度肥胖!!");
				}else if(result >=35){
					ta.append("你屬於重度肥胖!!");
				}
				if(b == true && Integer.parseInt(s4)>=90){
					ta.append("你的腰圍超出正常值了!\n");
				}else if(g==true && Integer.parseInt(s4)>=80){
					ta.append("你的腰圍超出正常值了!\n");
				}
				
			}
		});
	}

}
