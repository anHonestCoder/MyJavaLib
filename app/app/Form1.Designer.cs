namespace app
{
    partial class WinForm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(WinForm));
            this.resultText = new System.Windows.Forms.RichTextBox();
            this.inputText = new System.Windows.Forms.RichTextBox();
            this.submit = new System.Windows.Forms.Button();
            this.clearAll = new System.Windows.Forms.Button();
            this.clearResult = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // resultText
            // 
            this.resultText.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.resultText.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.resultText.Font = new System.Drawing.Font("微软雅黑", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.resultText.Location = new System.Drawing.Point(0, 22);
            this.resultText.Margin = new System.Windows.Forms.Padding(20, 0, 0, 0);
            this.resultText.Name = "resultText";
            this.resultText.ReadOnly = true;
            this.resultText.Size = new System.Drawing.Size(454, 111);
            this.resultText.TabIndex = 0;
            this.resultText.Text = "";
            this.resultText.MouseDown += new System.Windows.Forms.MouseEventHandler(this.resultText_MouseDown);
            // 
            // inputText
            // 
            this.inputText.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Left | System.Windows.Forms.AnchorStyles.Right)));
            this.inputText.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.inputText.Location = new System.Drawing.Point(3, 17);
            this.inputText.Margin = new System.Windows.Forms.Padding(0);
            this.inputText.Name = "inputText";
            this.inputText.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            this.inputText.Size = new System.Drawing.Size(450, 189);
            this.inputText.TabIndex = 1;
            this.inputText.Text = "";
            this.inputText.MouseDown += new System.Windows.Forms.MouseEventHandler(this.inputText_MouseDown);
            // 
            // submit
            // 
            this.submit.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.submit.Location = new System.Drawing.Point(375, 214);
            this.submit.Name = "submit";
            this.submit.Size = new System.Drawing.Size(75, 23);
            this.submit.TabIndex = 2;
            this.submit.Text = "汇总";
            this.submit.UseVisualStyleBackColor = true;
            this.submit.Click += new System.EventHandler(this.submit_button_click);
            // 
            // clearAll
            // 
            this.clearAll.Location = new System.Drawing.Point(109, 214);
            this.clearAll.Name = "clearAll";
            this.clearAll.Size = new System.Drawing.Size(85, 23);
            this.clearAll.TabIndex = 3;
            this.clearAll.Text = "清空全部";
            this.clearAll.UseVisualStyleBackColor = true;
            this.clearAll.Click += new System.EventHandler(this.clear_button_click);
            // 
            // clearResult
            // 
            this.clearResult.Location = new System.Drawing.Point(3, 214);
            this.clearResult.Name = "clearResult";
            this.clearResult.Size = new System.Drawing.Size(86, 23);
            this.clearResult.TabIndex = 6;
            this.clearResult.Text = "清空结果";
            this.clearResult.UseVisualStyleBackColor = true;
            this.clearResult.Click += new System.EventHandler(this.clearResult_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(0);
            this.groupBox1.Size = new System.Drawing.Size(463, 423);
            this.groupBox1.TabIndex = 7;
            this.groupBox1.TabStop = false;
            // 
            // groupBox3
            // 
            this.groupBox3.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox3.Controls.Add(this.inputText);
            this.groupBox3.Controls.Add(this.clearResult);
            this.groupBox3.Controls.Add(this.submit);
            this.groupBox3.Controls.Add(this.clearAll);
            this.groupBox3.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.groupBox3.Location = new System.Drawing.Point(4, 169);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(456, 245);
            this.groupBox3.TabIndex = 1;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "请输入数据";
            this.groupBox3.Enter += new System.EventHandler(this.groupBox3_Enter);
            // 
            // groupBox2
            // 
            this.groupBox2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox2.Controls.Add(this.resultText);
            this.groupBox2.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.groupBox2.Location = new System.Drawing.Point(3, 10);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(457, 136);
            this.groupBox2.TabIndex = 0;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "汇总结果";
            // 
            // WinForm
            // 
            this.AllowDrop = true;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(487, 447);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Sizable;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.ImeMode = System.Windows.Forms.ImeMode.On;
            this.MinimumSize = new System.Drawing.Size(487, 447);
            this.Name = "WinForm";
            this.Text = "汇总计算器";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.MouseDown += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseDown);
            this.MouseMove += new System.Windows.Forms.MouseEventHandler(this.Form1_MouseMove);
            this.groupBox1.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        private void initDictionay()
        {
            this.dictionary = new System.Collections.Generic.Dictionary<string, int>();
            string itemKeysStr = System.Configuration.ConfigurationSettings.AppSettings["itemKeys"].ToString();
            string[] itemKeysArray = System.Text.RegularExpressions.Regex.Split(itemKeysStr, ";");
            foreach (string str in itemKeysArray)
            {
                string item = str.Trim();
                if(!item.Equals(""))
                {
                    dictionary.Add(item, 0);
                } 
            }
        }

        #endregion

        private System.Windows.Forms.RichTextBox resultText;
        private System.Windows.Forms.RichTextBox inputText;
        private System.Windows.Forms.Button submit;
        private System.Windows.Forms.Button clearAll;
        private System.Collections.Generic.Dictionary<string, int> dictionary;
        private System.Windows.Forms.Button clearResult;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox3;
    }


}

