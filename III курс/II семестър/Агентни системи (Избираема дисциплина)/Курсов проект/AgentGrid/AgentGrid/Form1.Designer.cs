namespace AgentGrid
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.pnl_grid = new System.Windows.Forms.Panel();
            this.lbl_message = new System.Windows.Forms.Label();
            this.lbl_state = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // pnl_grid
            // 
            this.pnl_grid.Location = new System.Drawing.Point(12, 12);
            this.pnl_grid.Name = "pnl_grid";
            this.pnl_grid.Size = new System.Drawing.Size(501, 501);
            this.pnl_grid.TabIndex = 0;
            this.pnl_grid.Paint += new System.Windows.Forms.PaintEventHandler(this.pnl_grid_Paint);
            // 
            // lbl_message
            // 
            this.lbl_message.AutoSize = true;
            this.lbl_message.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbl_message.ForeColor = System.Drawing.Color.DodgerBlue;
            this.lbl_message.Location = new System.Drawing.Point(519, 296);
            this.lbl_message.Name = "lbl_message";
            this.lbl_message.Size = new System.Drawing.Size(0, 31);
            this.lbl_message.TabIndex = 2;
            // 
            // lbl_state
            // 
            this.lbl_state.AutoSize = true;
            this.lbl_state.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbl_state.ForeColor = System.Drawing.Color.Red;
            this.lbl_state.Location = new System.Drawing.Point(519, 236);
            this.lbl_state.Name = "lbl_state";
            this.lbl_state.Size = new System.Drawing.Size(0, 31);
            this.lbl_state.TabIndex = 3;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(808, 603);
            this.Controls.Add(this.lbl_state);
            this.Controls.Add(this.lbl_message);
            this.Controls.Add(this.pnl_grid);
            this.Name = "Form1";
            this.Text = "Form1";
            this.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Form1_KeyDown);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel pnl_grid;
        private System.Windows.Forms.Label lbl_message;
        private System.Windows.Forms.Label lbl_state;
    }
}

