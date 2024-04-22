
    private void drawHealthBar(Graphics g) {
        int heartWidth = 80 ;
        int heartHeight = 80;
        int heartXOffset = (heartWidth + 10) * 3 / 2;
        int heartX = (int) (xPos - heartXOffset / 2);
        int heartY = (int) (yPos - height) + 100;

        for (int i = 0; i < 3; i++) {
            Image heartImage = emptyHeart;
            if (hp > (i * 2) + 1) {
                heartImage = fullHeart;
            } else if (hp > i * 2) {
                heartImage = halfHeart;
            }
          
            g.drawImage(heartImage, heartX + (i * (heartWidth + 10)), heartY, heartWidth, heartHeight, null);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, (int) (xPos - width / 2), (int) (yPos - height / 2), null);
        drawHealthBar(g);
    }
