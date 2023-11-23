using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AgentGrid
{

    public partial class Form1 : Form
    {
        int x = 50;
        int y = 50;
        int [,] gridData = new int [10,10]
        {   {0, 0, 1, 1, 1, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0, 0, 0, 0, 1, 1}};

        public struct agent
        {
            public int x,y;
            public agent(int p1, int p2)
            {
                x = p1;
                y = p2;
            }
        };

            Graphics g;
            Pen pen = new Pen(Color.Black);
            SolidBrush brush = new SolidBrush(Color.Blue);
            SolidBrush brushGreen = new SolidBrush(Color.Green);
            SolidBrush brushPink = new SolidBrush(Color.Pink);
            SolidBrush brushRed = new SolidBrush(Color.Red);
            
            agent myAgent = new agent(0,9);

        public Form1()
        {
            InitializeComponent();
            g = pnl_grid.CreateGraphics();
            g.SmoothingMode = SmoothingMode.AntiAlias;
        }

       public int CoordinatesToState(agent ag)
        {
            int state = 0;
            state = ag.y * 10 + ag.x;

            return state;
        }

        public agent StateToCoordinates(int state)
       {
            agent Myagent = new agent();
            
            Myagent.x = state % 10;
            Myagent.y = state / 10;

            return Myagent;
       }
        
        public void DrawGrid()
        {
            int i = 0;
            int j = 0;
            for (i = 0; i < 11; i++)
            {
                g.DrawLine(pen, 0, i * y, 800, i * y);
                for (j = 0; j < 11; j++)
                {
                    g.DrawLine(pen, j * x, 0, j * x, 800);
                    if (i < 10 && j < 10 && gridData[i, j] == 1)
                    {
                        g.FillRectangle(brush, j * x, i * y, 50, 50);
                    }
                }
            }
            g.FillRectangle(brushGreen, 0, 450, 50, 50);//initial state s0 = 90
            g.FillRectangle(brushPink, 450, 150, 50, 50);// x = 9, y = 3, s = 39 - terminal state st

            //g.FillEllipse(brushRed, 0, 450, 50, 50);
        }
        public void MoveAgent(int direction)
        {
            //1- up; 2-down; 3-left;4-right;
            switch(direction)
            {
                case 1: if (myAgent.y - 1 >= 0 && gridData[myAgent.y-1, myAgent.x] != 1) myAgent.y -= 1; break;
                case 2: if (myAgent.y + 1 <= 9 && gridData[myAgent.y + 1, myAgent.x] != 1) myAgent.y += 1; break;
                case 3: if (myAgent.x - 1 >= 0 && gridData[myAgent.y, myAgent.x-1] != 1) myAgent.x -= 1; break;
                case 4: if (myAgent.x + 1 <= 9 && gridData[myAgent.y, myAgent.x+1] != 1) myAgent.x += 1; break;
            }
            g.FillEllipse(brushRed, myAgent.x*50, myAgent.y*50, 50, 50);
            pnl_grid.Refresh();
            lbl_state.Text = "State: " + CoordinatesToState(myAgent).ToString();
            agent agt = StateToCoordinates(CoordinatesToState(myAgent));

            lbl_message.Text = "Position : " + agt.x + ", " + agt.y; 
        }
        
        

        private void pnl_grid_Paint(object sender, PaintEventArgs e)
        {
           DrawGrid();
           g.FillEllipse(brushRed, myAgent.x * 50, myAgent.y * 50, 50, 50);
        }

        private void Form1_KeyDown(object sender, KeyEventArgs e)
        { 
            //DrawGrid();
            switch (e.KeyValue)
            {
                case 38: MoveAgent(1); break;
                case 40: MoveAgent(2); break;
                case 37: MoveAgent(3); break;
                case 39: MoveAgent(4); break;
            } 
        }

        
    }
}
