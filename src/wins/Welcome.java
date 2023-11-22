package wins;

import wins.otherwins.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome {
    JFrame frame = new JFrame();
    public Welcome(){
        frame.setTitle("Maringo Sports System");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel mainLabel = new JLabel("Welcome, Maringo Sports Club Management System",SwingConstants.CENTER);
        mainLabel.setFont(new Font(null,Font.BOLD,20));
        mainLabel.setForeground(Color.BLUE);
        mainLabel.setBounds(25,10,700,40);
        mainLabel.setBorder(new LoginForm.RoundBorder(4));
        frame.add(mainLabel);

        JLabel Image = new JLabel(new ImageIcon("src/res/welcome_background.jpg"));
        Image.setBounds(25,55,400,490);
        frame.add(Image);

        JLabel membersLabel = new JLabel("Membership Management");
        membersLabel.setBounds(438,55,200,30);
        membersLabel.setFont(new Font(null,Font.BOLD,16));
        //membersLabel.setBorder(new LoginForm.RoundBorder(4));
        frame.add(membersLabel);

        JPanel memberPanel = new JPanel();
        memberPanel.setLayout(null);
        memberPanel.setBounds(438,90,330,85);
        memberPanel.setBackground(new Color(255,255,255,80));
        JLabel viewmember = new JLabel("View Members",SwingConstants.CENTER);
        viewmember.setForeground(Color.BLACK);
        viewmember.setBounds(10,10,130,30);
        viewmember.setBorder(new LoginForm.RoundBorder(4));
        viewmember.setOpaque(true);
        viewmember.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                viewmember.setForeground(Color.RED);
                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new ViewMembers(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                viewmember.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewmember.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewmember.setBackground(Color.WHITE);
                viewmember.setForeground(Color.BLACK);
            }
        });

        memberPanel.add(viewmember);
        JLabel registermember = new JLabel("Register Member",SwingConstants.CENTER);
        registermember.setForeground(Color.ORANGE);
        registermember.setBounds(10,50,130,30);
        registermember.setBorder(new LoginForm.RoundBorder(4));
        registermember.setOpaque(true);
        registermember.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                registermember.setForeground(Color.RED);
                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new RegisterMember(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                registermember.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registermember.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registermember.setBackground(Color.WHITE);
                registermember.setForeground(Color.YELLOW);
            }
        });

        memberPanel.add(registermember);
        frame.add(memberPanel);

        JLabel gamesLabel = new JLabel("Games and Fee Facilitation");
        gamesLabel.setBounds(438,180,250,30);
        gamesLabel.setFont(new Font(null,Font.BOLD,16));
        //membersLabel.setBorder(new LoginForm.RoundBorder(4));
        frame.add(gamesLabel);

        JPanel gamesPanel = new JPanel();
        gamesPanel.setLayout(null);
        gamesPanel.setBounds(438,215,330,85);
        gamesPanel.setBackground(new Color(255,255,255,100));

        JLabel viewGames = new JLabel("View Games",SwingConstants.CENTER);
        viewGames.setBounds(10,10,130,30);
        viewGames.setBorder(new LoginForm.RoundBorder(4));
        viewGames.setOpaque(true);
        gamesPanel.add(viewGames);
        viewGames.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                viewGames.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ViewGames(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                viewGames.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                viewGames.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                viewGames.setBackground(Color.WHITE);
                viewGames.setForeground(Color.BLACK);
            }
        });

        JLabel newEvent = new JLabel("Schedule Event",SwingConstants.CENTER);
        newEvent.setForeground(Color.ORANGE);
        newEvent.setBounds(10,50,130,30);
        newEvent.setBorder(new LoginForm.RoundBorder(4));
        newEvent.setOpaque(true);
        newEvent.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                newEvent.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new GameFacilitation();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newEvent.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                newEvent.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newEvent.setBackground(Color.WHITE);
                newEvent.setForeground(Color.ORANGE);
            }
        });

        gamesPanel.add(newEvent);
        JLabel pastEvents = new JLabel("View Past Events",SwingConstants.CENTER);
        pastEvents.setBounds(160,50,130,30);
        pastEvents.setBorder(new LoginForm.RoundBorder(4));
        pastEvents.setOpaque(true);
        pastEvents.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                pastEvents.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new EventsReport(new JFrame());
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pastEvents.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                pastEvents.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pastEvents.setBackground(Color.WHITE);
                pastEvents.setForeground(Color.BLACK);
            }
        });

        gamesPanel.add(pastEvents);
        frame.add(gamesPanel);

        JLabel storeLabel = new JLabel("Store and Items Management");
        storeLabel.setBounds(438,305,250,30);
        storeLabel.setFont(new Font(null,Font.BOLD,16));
        //membersLabel.setBorder(new LoginForm.RoundBorder(4));
        frame.add(storeLabel);

        JPanel storePanel = new JPanel();
        storePanel.setLayout(null);
        storePanel.setBounds(438,340,330,85);
        storePanel.setBackground(new Color(255,255,255,100));

        JLabel items = new JLabel("View Items",SwingConstants.CENTER);
        items.setBounds(10,10,130,30);
        items.setBorder(new LoginForm.RoundBorder(4));
        items.setOpaque(true);
        items.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                items.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ViewItems(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                items.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                items.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                items.setBackground(Color.WHITE);
                items.setForeground(Color.BLACK);
            }
        });

        storePanel.add(items);
        JLabel newSale = new JLabel("New Sale",SwingConstants.CENTER);
        newSale.setForeground(Color.ORANGE);
        newSale.setBounds(10,50,130,30);
        newSale.setBorder(new LoginForm.RoundBorder(4));
        newSale.setOpaque(true);
        newSale.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                newSale.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new NewSale();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newSale.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                newSale.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                newSale.setBackground(Color.WHITE);
                newSale.setForeground(Color.ORANGE);
            }
        });

        storePanel.add(newSale);

        JLabel recentSales = new JLabel("Recent Sales",SwingConstants.CENTER);
        recentSales.setFont(new Font(null,Font.BOLD,12));
        recentSales.setBounds(160,50,130,30);
        recentSales.setBorder(new LoginForm.RoundBorder(4));
        recentSales.setOpaque(true);
        recentSales.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                recentSales.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new SalesReport(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                recentSales.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                recentSales.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                recentSales.setBackground(Color.WHITE);
                recentSales.setForeground(Color.BLACK);
            }
        });
        storePanel.add(recentSales);
        frame.add(storePanel);

        JLabel reportsLabel = new JLabel("Generate Reports");
        reportsLabel.setBounds(438,430,200,30);
        reportsLabel.setFont(new Font(null,Font.BOLD,16));
        //membersLabel.setBorder(new LoginForm.RoundBorder(4));
        frame.add(reportsLabel);

        JPanel reportsPanel = new JPanel();
        reportsPanel.setLayout(null);
        reportsPanel.setBounds(438,465,330,85);
        reportsPanel.setBackground(new Color(255,255,255,100));

        JLabel membersReport = new JLabel("Members Report",SwingConstants.CENTER);
        membersReport.setForeground(Color.RED);
        membersReport.setBounds(10,10,130,30);
        membersReport.setBorder(new LoginForm.RoundBorder(4));
        membersReport.setOpaque(true);
        membersReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                membersReport.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new Login();
                        //viewmember.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                membersReport.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                membersReport.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                membersReport.setBackground(Color.WHITE);
            }
        });

        reportsPanel.add(membersReport);
        JLabel eventsReport = new JLabel("Events Report",SwingConstants.CENTER);
        eventsReport.setForeground(Color.RED);
        eventsReport.setBounds(10,50,130,30);
        eventsReport.setBorder(new LoginForm.RoundBorder(4));
        eventsReport.setOpaque(true);
        eventsReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                eventsReport.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new Login();
                        //viewmember.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eventsReport.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eventsReport.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eventsReport.setBackground(Color.WHITE);
            }
        });

        reportsPanel.add(eventsReport);
        JLabel salesReport = new JLabel("Sales Report",SwingConstants.CENTER);
        salesReport.setForeground(Color.RED);
        salesReport.setBounds(160,10,130,30);
        salesReport.setBorder(new LoginForm.RoundBorder(4));
        salesReport.setOpaque(true);
        salesReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                salesReport.setBackground(Color.DARK_GRAY);


                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new SalesReport(frame);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                salesReport.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                salesReport.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                salesReport.setBackground(Color.WHITE);
            }
        });

        reportsPanel.add(salesReport);
        JLabel incomeReport = new JLabel("Income Report",SwingConstants.CENTER);
        incomeReport.setForeground(Color.RED);
        incomeReport.setBounds(160,50,130,30);
        incomeReport.setBorder(new LoginForm.RoundBorder(4));
        incomeReport.setOpaque(true);
        incomeReport.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //viewmember.setEnabled(false);
                incomeReport.setForeground(Color.RED);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        new Login();
                        //viewmember.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                incomeReport.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                incomeReport.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                incomeReport.setBackground(Color.WHITE);
            }
        });

        reportsPanel.add(incomeReport);
        frame.add(reportsPanel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Welcome();
    }
}
